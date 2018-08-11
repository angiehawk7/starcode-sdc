package org.starcode.starsdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.starcode.starsdc.template.TemplateManager;
import org.starcode.starsdc.utils.SDCGlobalEnv;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 14:55
 * 描述:xxx
 */
public class SDCApplication {
    private static final Logger LOG = LoggerFactory.getLogger(SDCApplication.class);
    public static void main(String[] args) throws Exception {
        SDCGlobalEnv env=SDCGlobalEnv.getInstance();
        TemplateManager manager=TemplateManager.getInstance();
        env.start();
        SpringApplication app=new SpringApplication(SDCApplication.class);
        app.setDefaultProperties(env.getAll());
        app.addListeners(new SDCApplicationEventListener());
        app.run(args);
        manager.start();
        LOG.info("SDCApplication start success.");
    }
}
