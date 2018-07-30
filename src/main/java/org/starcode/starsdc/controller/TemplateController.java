package org.starcode.starsdc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 14:28
 * 描述:Template Restfull API
 */
@RestController
@RequestMapping("/")
public class TemplateController {

    /**
     * 查询所有模板列表
     * @return
     */
    @GetMapping("/templates")
    String queryAll() {
        return "ok";
    }

    /**
     * 指定NS查询其所有模板列表
     * @param ns
     * @return
     */
    @GetMapping("/templates/{ns}")
    String queryNSTemplatez(@PathVariable String ns) {
        return "ok";
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
        return "ok";
    }
}
