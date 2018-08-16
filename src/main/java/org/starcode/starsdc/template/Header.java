package org.starcode.starsdc.template;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.starcode.starsdc.utils.AdapterRequest;
import org.starcode.starsdc.utils.SDCException;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:35
 * 描述:xxx
 */
public class Header {

    private static final String X_PATH="/template/header";
    //header模板
    private String headerText;

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    /**
     *
     * 解析模板文件
     * @param doc 模板文件
     * @return
     * @throws SDCException
     */
    public static Header create(Document doc) throws SDCException {
        Node node=doc.selectSingleNode(X_PATH);
        if(null == node){
            return null;
        }
        Header header=new Header();
        Element element=(Element)node;
        header.setHeaderText(element.getTextTrim());
        return header;

    }

    /**
     * 属性校验
     * @param ns
     * @param id
     * @throws SDCException
     */
    public void validate(String ns,String id) throws SDCException{
        return;
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
