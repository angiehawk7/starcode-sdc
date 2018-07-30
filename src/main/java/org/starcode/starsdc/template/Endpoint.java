package org.starcode.starsdc.template;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:35
 * 描述:endpoint对象
 */
public class Endpoint {
    //连接超时
    private long connTimeOut;
    //传输超时
    private long transferTimeOut;
    //连接模板
    private String endpointText;

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
}
