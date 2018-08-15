package org.starcode.starsdc.template;

import org.dom4j.Document;
import org.starcode.starsdc.utils.SDCException;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:35
 * 描述:xxx
 */
public class Header {
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
     * @param ns ns
     * @return
     * @throws SDCException
     */
    public static Header create(Document doc,String ns) throws SDCException {
        return null;

    }

    /**
     * 属性校验
     * @throws SDCException
     */
    public void validate() throws SDCException{

    }
}
