package org.starcode.starsdc.template;

import org.dom4j.Document;
import org.starcode.starsdc.utils.SDCException;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:36
 * 描述:response模板
 */
public class Response {
    //response模板
    private String responseText;
    //response类型：Java||Freemarker||Python
    private String type;

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 创建response对象
     * @param doc
     * @param ns
     * @return
     * @throws SDCException
     */
    public static Response create(Document doc,String ns) throws SDCException {
        return null;

    }

    /**
     * 属性校验
     * @throws SDCException
     */
    public void validate() throws SDCException{

    }
}
