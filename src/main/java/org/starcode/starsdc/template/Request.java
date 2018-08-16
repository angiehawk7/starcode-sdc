package org.starcode.starsdc.template;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.starcode.starsdc.utils.AdapterRequest;
import org.starcode.starsdc.utils.SDCException;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:35
 * 描述:Request模板
 */
public class Request {
    private static final String X_PATH="/template/request";
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

    /**
     * 创建Request对象
     * @param doc
     * @return
     * @throws SDCException
     */
    public static Request create(Document doc) throws SDCException {
        Node node=doc.selectSingleNode(X_PATH);
        if(null == node){
            return null;
        }
        Request req=new Request();
        Element element=(Element)node;
        req.setType(element.attributeValue("type"));
        req.setRequestText(element.getTextTrim());
        return req;
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
