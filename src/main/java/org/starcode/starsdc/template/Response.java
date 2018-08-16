package org.starcode.starsdc.template;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.starcode.starsdc.utils.AdapterRequest;
import org.starcode.starsdc.utils.SDCException;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:36
 * 描述:response模板
 */
public class Response {
    private static final String X_PATH="/template/response";
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
     * @return
     * @throws SDCException
     */
    public static Response create(Document doc) throws SDCException {
        Node node=doc.selectSingleNode(X_PATH);
        if(null == node){
            return null;
        }
        Response rsp=new Response();
        Element element=(Element)node;
        rsp.setType(element.attributeValue("type"));
        rsp.setResponseText(element.getTextTrim());
        return rsp;

    }

    /**
     * 属性校验
     * @param ns
     * @param id
     * @throws SDCException
     */
    public void validate(String ns,String id) throws SDCException{
        //TODO 校验type
    }

    /**
     * 模板翻译
     * @param req
     * @return
     * @throws SDCException
     */
    public String transfter(AdapterRequest req) throws SDCException{
        return null;
    }
}
