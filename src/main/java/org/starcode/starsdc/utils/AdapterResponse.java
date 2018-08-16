package org.starcode.starsdc.utils;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 14:19
 * 描述:xxx
 */
public class AdapterResponse {
    private String code;
    private String msg;
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
