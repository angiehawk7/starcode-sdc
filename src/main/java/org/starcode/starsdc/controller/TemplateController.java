package org.starcode.starsdc.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.starcode.starsdc.template.Template;
import org.starcode.starsdc.template.TemplateManager;
import org.starcode.starsdc.template.TemplateStorage;
import org.starcode.starsdc.utils.AdapterResponse;

import java.util.List;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 14:28
 * 描述:Template Restfull API
 */
@RestController
@RequestMapping("/")
public class TemplateController {

    private TemplateStorage storage=TemplateManager.getInstance().getStorage();
    /**
     * 查询所有模板列表
     * @return
     */
    @GetMapping("/templates")
    String queryAll() {
        List<Template> templates=storage.listAll();
        AdapterResponse response=new AdapterResponse();
        response.setData(templates);
        return JSON.toJSONString(response);
    }

    /**
     * 指定NS查询其所有模板列表
     * @param ns
     * @return
     */
    @GetMapping("/templates/{ns}")
    String queryNSTemplatez(@PathVariable String ns) {
        List<Template> templates=storage.listTemplates(ns);
        AdapterResponse response=new AdapterResponse();
        response.setData(templates);
        return JSON.toJSONString(response);
    }

    /**
     * 查询模板详情
     * @param ns 命名空间
     * @param id 模板ID
     * @return 模板详情
     */
    @GetMapping("/template/{ns}/{id}")
    String getTemplate(@PathVariable String ns,
                       @PathVariable String id) {
        Template tpl=storage.getTemplate(ns,id);
        AdapterResponse response=new AdapterResponse();
        response.setData(tpl);
        return JSON.toJSONString(response);
    }
}
