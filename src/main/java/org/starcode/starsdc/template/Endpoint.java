package org.starcode.starsdc.template;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.starcode.starsdc.utils.AdapterRequest;
import org.starcode.starsdc.utils.SDCException;


/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:35
 * 描述:endpoint对象
 */
public class Endpoint {

    private static final String X_PATH="/template/endpoint";
    private static final int MAX_TIMEOUT=300;
    //连接超时
    private long connTimeOut;
    //传输超时
    private long transferTimeOut;
    //连接模板
    private String endpointText="";

    public long getConnTimeOut() {
        return connTimeOut;
    }

    public void setConnTimeOut(long connTimeOut) {
        this.connTimeOut = connTimeOut;
    }

    public long getTransferTimeOut() {
        return transferTimeOut;
    }

    public void setTransferTimeOut(long transferTimeOut) {
        this.transferTimeOut = transferTimeOut;
    }

    public String getEndpointText() {
        return endpointText;
    }

    public void setEndpointText(String endpointText) {
        this.endpointText = endpointText;
    }

    /**
     *
     * 解析模板文件
     * @param doc 模板文件
     * @return
     * @throws SDCException
     */
    public static Endpoint create(Document doc) throws SDCException {
        Node node=doc.selectSingleNode(X_PATH);
        if(null == node){
            return null;
        }
        Endpoint endpoint=new Endpoint();
        Element element=(Element)node;
        endpoint.setConnTimeOut(Long.valueOf(element.attributeValue("conn_timeout")));
        endpoint.setTransferTimeOut(Long.valueOf(element.attributeValue("transfer_timeOut")));
        endpoint.setEndpointText(element.getTextTrim());
        return endpoint;

    }

    /**
     * 属性校验
     * @param ns
     * @param id
     * @throws SDCException
     */
    public void validate(String ns,String id) throws SDCException{
        if(this.getConnTimeOut()>MAX_TIMEOUT || this.getTransferTimeOut()> MAX_TIMEOUT){
            throw new SDCException("","");
        }
        //TODO 如果protocol是https，http，jdbc，file，ssh 则必须指定endpoint。
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
