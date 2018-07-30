package org.starcode.starsdc.template;


import java.io.File;
import java.util.List;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:53
 * 描述:模板管理：模板的增删改查。
 */
public class TemplateManager {
    private static TemplateManager instance=null;
    private TemplateManager(){

    }
    public static TemplateManager getInstance(){
        if(instance == null){
            synchronized(TemplateManager.class){
                if(instance == null){
                    instance=new TemplateManager();
                }
            }
        }
        return instance;
    }

    /**
     * 启动初始化
     */
    public void start(){

    }

    /**
     * 停止处理
     */
    public void stop(){

    }

    /**
     * 发现模板文件
     * @param ns 命名空间
     * @return 模板文件列表
     */
    public List<File> discover(String ns){
        return null;
    }

    /**
     * 解析模板文件
     * @param ns 命名空间
     * @param tplF 模板文件
     */
    public void processTemplate(String ns,File tplF){

    }
}
