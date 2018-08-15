package org.starcode.starsdc.template;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.starcode.starsdc.utils.SDCException;
import org.starcode.starsdc.utils.SDCGlobalEnv;
import org.starcode.starsdc.utils.SDCUtil;

import java.io.File;
import java.util.List;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:53
 * 描述:模板管理：模板的增删改查。
 */
public class TemplateManager {
    private static final Logger LOG = LoggerFactory.getLogger(TemplateManager.class);
    private static final String ATOMIC_ROOT = "atomic";
    private static final String STORAGE_KEY = "tpl.storage";
    private static TemplateManager instance = null;
    private TemplateStorage storage=null;
    private SDCGlobalEnv env=SDCGlobalEnv.getInstance();
    private TemplateManager() {

    }

    public static TemplateManager getInstance() {
        if (instance == null) {
            synchronized (TemplateManager.class) {
                if (instance == null) {
                    instance = new TemplateManager();
                }
            }
        }
        return instance;
    }

    /**
     * 启动初始化
     */
    public void start() throws Exception {
        LOG.info("TemplateManager.start.");
        String storageType=env.getEnv(STORAGE_KEY);
        if("mem".equals(storageType)){
            storage=new TemplateStorageMem();
        }else{
            storage=new TemplateStorageMem();
        }
        loadTpl();
        LOG.info("TemplateManager.start end.");
    }

    /**
     * 停止处理
     */
    public void stop() {
        storage.clean();
        storage = null;
        LOG.info("TemplateManager.stop end.");
    }

    private void loadTpl() throws Exception{
        String adapterRoot = SDCGlobalEnv.getInstance().getAdapterRoot();
        File adapterf = new File(adapterRoot);
        if (!adapterf.exists()) {
            return;
        }
        String[] nss = adapterf.list();
        if (SDCUtil.arrayEmpty(nss)) {
            return;
        }
        for (String ns : nss) {
            try {
                processTemplate(ns);
            } catch (SDCException e) {
                LOG.error(e.getLocalizedMessage(), e);
            }
        }
    }
    /**
     * 解析模板文件
     *
     * @param ns 命名空间
     */
    private void processTemplate(String ns) throws SDCException {
        String adapterRoot = SDCGlobalEnv.getInstance().getAdapterRoot();
        StringBuilder sb = new StringBuilder();
        sb.append(adapterRoot).append(File.separator)
                .append(ns).append(File.separator)
                .append(ATOMIC_ROOT);
        File atoF = new File(sb.toString());
        if (!atoF.exists()) {
            return;
        }
        File[] atoFiles = atoF.listFiles();
        if (SDCUtil.arrayEmpty(atoFiles)) {
            return;
        }
        for (File f : atoFiles) {
            Template tpl = Template.create(f,ns);
            storage.addTempate(tpl);
        }
    }
}
