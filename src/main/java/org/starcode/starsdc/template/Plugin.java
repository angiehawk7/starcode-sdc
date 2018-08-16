package org.starcode.starsdc.template;

import org.dom4j.Document;
import org.starcode.starsdc.utils.AdapterRequest;
import org.starcode.starsdc.utils.SDCException;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:35
 * 描述:Plugin对象
 */
public class Plugin {
    private String type;
    private String pluginText;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPluginText() {
        return pluginText;
    }

    public void setPluginText(String pluginText) {
        this.pluginText = pluginText;
    }

    /**
     * 创建前置插件对象
     * @param doc
     * @return
     * @throws SDCException
     */
    public static Plugin createReqPlugin(Document doc) throws SDCException {
        return null;

    }

    /**
     * 创建后置插件对象
     * @param doc
     * @return
     * @throws SDCException
     */
    public static Plugin createRspPlugin(Document doc) throws SDCException {
        return null;

    }
    /**
     * 属性校验
     * @param ns
     * @param id
     * @throws SDCException
     */
    public void validate(String ns,String id) throws SDCException{

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
