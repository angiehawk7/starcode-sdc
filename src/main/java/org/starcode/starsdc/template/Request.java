package org.starcode.starsdc.template;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:35
 * 描述:Request模板
 */
public class Request {
    //request模板
    private String requestText;
    //request类型：Java||Freemarker||Python
    private String type;

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
