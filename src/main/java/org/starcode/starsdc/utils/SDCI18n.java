package org.starcode.starsdc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 作者:angie_hawk7
 * 日期:2018/8/16 11:45
 * 描述: 国际化词条管理
 */
public class SDCI18n {
    private static final Logger LOG = LoggerFactory.getLogger(SDCI18n.class);
    private static SDCI18n instance = null;
    private SDCI18n() {

    }

    public static SDCI18n getInstance() {
        if (instance == null) {
            synchronized (SDCGlobalEnv.class) {
                if (instance == null) {
                    instance = new SDCI18n();
                }
            }
        }
        return instance;
    }
}
