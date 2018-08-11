package org.starcode.starsdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.starcode.starsdc.template.TemplateManager;

/**
 * 作者:angie_hawk7
 * 日期:2018/8/11 10:33
 * 描述:xxx
 */
public class SDCApplicationEventListener implements ApplicationListener {
    private static final Logger LOG = LoggerFactory.getLogger(SDCApplicationEventListener.class);
    public void onApplicationEvent(ApplicationEvent event) {
        TemplateManager manager=TemplateManager.getInstance();
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            LOG.info("init env finished.");
        }else if (event instanceof ApplicationPreparedEvent) {
            LOG.info("init finished.");
        }else if (event instanceof ContextRefreshedEvent) {
            LOG.info("app refreshed.");
        }else if (event instanceof ApplicationReadyEvent) {
            LOG.info("app start finished.");
        }else if (event instanceof ContextStartedEvent) {
            LOG.info("app start begin.");
        }else if (event instanceof ContextStoppedEvent) {
            LOG.info("app stop finished.");
            manager.stop();
        }else if (event instanceof ContextClosedEvent) {
            LOG.info("app closed finished.");
            manager.stop();
        }else {
            LOG.info("what is this..");
        }
    }
}
