package org.starcode.starsdc.template;

import java.util.List;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:53
 * 描述:模板存储
 */
public interface TemplateStorage {
    //增加模板
    void addTempate(Template tpl);

    //删除模板
    void deleteTemplate(String ns,String id);

    //查询指定ns下的模板列表
    List<Template> listTemplates(String ns);

    //查询指定模板的详情
    Template getTemplate(String id);

    //获取所有的模板列表
    List<Template> listAll();

    void clean();

}
