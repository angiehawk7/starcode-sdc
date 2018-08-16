package org.starcode.starsdc.utils;

/**
 * 作者:angie_hawk7
 * 日期:2018/8/16 11:29
 * 描述:错误码定义
 */
public enum SDCCodeEnum {

    SUCCESS_CODE("0","Success."),
    EXCEPTION_CODE("-1","Unkown Exception."),

    HEAD_CODE_1001("1001",""),
    HEAD_CODE_1002("1002",""),
    ENDPOINT_CODE_2001("2001",""),
    ENDPOINT_CODE_2002("2001",""),
    REQUEST_CODE_3001("3001",""),
    REQUEST_CODE_3002("3002",""),
    REQUEST_CODE_3003("3003",""),
    RESPONSE_CODE_4001("4001",""),
    RESPONSE_CODE_4002("4002",""),
    RESPONSE_CODE_4003("4003",""),
    RESPONSE_CODE_4004("4004",""),
    TEMPLATE_CODE_5001("5001","");
    private String code;
    private String msg;

    SDCCodeEnum(String code,String msg) {
        this.code = code;
        this.msg=msg;
    }

    /**
     * 国际化翻译
     * @param args 参数
     * @return
     */
    public String getMsg(Object[] args) {
        //TODO 国际化翻译
        return msg;
    }
}
