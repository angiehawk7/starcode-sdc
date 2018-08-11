package org.starcode.starsdc.template;

import org.starcode.starsdc.utils.SDCException;

import java.io.File;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:36
 * 描述:原子模板对象
 */
public class Template {
    //模板namespace
    private String ns;
    //模板标识
    private String id;
    //模板名称
    private String name;
    //模板使用的协议
    private String protocol;
    //模板日志级别
    private String log;
    //模板执行实例存储类别
    private String storage;
    //模板执行实例保存时常：秒
    private String ttl;
    //endpoint
    private Endpoint endpoint;
    //header
    private Header header;
    //request 前置插件
    private Plugin preRequestPlugin;
    //request
    private Request request;
    //response 前置插件
    private Plugin preResponsePlugin;
    //response
    private Response response;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Template template = (Template) o;

        if (ns != null ? !ns.equals(template.ns) : template.ns != null) return false;
        return id != null ? id.equals(template.id) : template.id == null;
    }

    @Override
    public int hashCode() {
        int result = ns != null ? ns.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }


    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Plugin getPreRequestPlugin() {
        return preRequestPlugin;
    }

    public void setPreRequestPlugin(Plugin preRequestPlugin) {
        this.preRequestPlugin = preRequestPlugin;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Plugin getPreResponsePlugin() {
        return preResponsePlugin;
    }

    public void setPreResponsePlugin(Plugin preResponsePlugin) {
        this.preResponsePlugin = preResponsePlugin;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     * 解析模板文件
     * @param f 模板文件
     * @param ns ns
     */
    public void parse(File f, String ns) throws SDCException{
        //解析文件
    }

    /**
     * 属性校验
     */
    private void validate() throws SDCException{

    }
}
