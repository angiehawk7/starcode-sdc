package org.starcode.starsdc.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 作者:angie_hawk7
 * 日期:2018/8/11 8:48
 * 描述:全局环境变量管理
 */
public class SDCGlobalEnv {
    private static final Logger LOG = LoggerFactory.getLogger(SDCGlobalEnv.class);
    private static SDCGlobalEnv instance = null;
    private static final String APP_ROOT = "D:" + File.separator + "githubcode" + File.separator + "starcode-sdc";
    private static final String ADAPTER_KEY = "adapter.root";
    private static final String APP_KEY = "app.root";
    private static Properties pro = new Properties();

    private SDCGlobalEnv() {

    }

    public static SDCGlobalEnv getInstance() {
        if (instance == null) {
            synchronized (SDCGlobalEnv.class) {
                if (instance == null) {
                    instance = new SDCGlobalEnv();
                }
            }
        }
        return instance;
    }

    /**
     * 启动
     */
    public void start() throws IOException {
        StringBuilder sb = new StringBuilder();
        String appRoot = System.getenv(APP_KEY);
        if (StringUtils.isEmpty(appRoot)) {
            appRoot = APP_ROOT;
            pro.put(APP_KEY, appRoot);
        }
        sb.append(appRoot).append(File.separator).
                append("deployment").append(File.separator).
                append("etc").append(File.separator).append("app.properties");
        FileInputStream instream = FileUtils.openInputStream(new File(sb.toString()));
        pro.load(instream);
        pro.putAll(System.getenv());
        LOG.info("SDCGlobalEnv.start:{}", JSON.toJSONString(pro));
    }

    /**
     * 停止
     */
    public void stop() {
        pro.clear();
        instance = null;
        LOG.info("SDCGlobalEnv.stop:{}", JSON.toJSONString(pro));
    }

    /**
     * 获取指定的环境变量
     *
     * @param key
     * @return
     */
    public String getEnv(String key) {
        return pro.getProperty(key);
    }

    /**
     * 获取运行程序根目录
     *
     * @return
     */
    public String getRoot() {
        return getEnv(APP_KEY);
    }

    /**
     * 获取适配模板根目录
     *
     * @return
     */
    public String getAdapterRoot() {
        StringBuilder sb = new StringBuilder();
        sb.append(getRoot()).append(File.separator).append(getEnv(ADAPTER_KEY));
        return sb.toString();
    }

    /**
     * 获取所有变量
     * @return
     */
    public Properties getAll(){
        return pro;
    }
}
