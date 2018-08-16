package org.starcode.starsdc.utils;

/**
 * 作者:angie_hawk7
 * 日期:2018/8/11 9:49
 * 描述:xxx
 */
public class SDCException extends Exception {
    private String code;
    public SDCException(Throwable cause) {
        super(cause);
    }
    public SDCException(String code,String msg) {
        super(msg);
        this.code=code;
    }

    public String getCode() {
        return code;
    }

}
