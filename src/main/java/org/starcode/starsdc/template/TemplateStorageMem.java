package org.starcode.starsdc.template;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 作者:angie_hawk7
 * 日期:2018/7/30 13:54
 * 描述:模板内存存储
 */
public class TemplateStorageMem implements TemplateStorage {
    private static final String INDEX_SPLITE="#$@";
    private static TemplateStorageMem instance = null;
    private Map<String,Map<String,Template>> indexMap=
            new ConcurrentHashMap<String,Map<String,Template>>();
    private TemplateStorageMem() {

    }

    public static TemplateStorageMem getInstance() {
        if (instance == null) {
            synchronized (TemplateStorageMem.class) {
                if (instance == null) {
                    instance = new TemplateStorageMem();
                }
            }
        }
        return instance;
    }

    /**
     * 生成模板唯一标识
     * @param ns
     * @param id
     * @return
     */
    private String gernateIndex(String ns,String id){
        StringBuilder sb=new StringBuilder();
        sb.append(ns).append(INDEX_SPLITE).append(id);
        return sb.toString();
    }

    public void addTempate(Template tpl) {
        String index=gernateIndex(tpl.getNs(),tpl.getId());
        Map<String,Template> tplMap=indexMap.get(tpl.getNs());
        if(null == tplMap){
            tplMap=new HashMap<String, Template>();
            indexMap.put(tpl.getNs(),tplMap);
        }
        tplMap.put(index,tpl);
    }

    public void deleteTemplate(String ns, String id) {
        String index=gernateIndex(ns,id);
        Map<String,Template> tplMap=indexMap.get(ns);
        if(null == tplMap){
            return;
        }
        tplMap.remove(index);
    }

    public List<Template> listTemplates(String ns) {
        Map<String,Template> tplMap=indexMap.get(ns);
        Collection<Template> cols=tplMap.values();
        return JSON.parseObject(JSON.toJSONString(cols),List.class);
    }

    public Template getTemplate(String ns, String id) {
        String index=gernateIndex(ns,id);
        Map<String,Template> tplMap=indexMap.get(ns);
        if(null == tplMap){
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(tplMap.get(index)),Template.class);
    }

    public List<Template> listAll() {
        List<Template> values=new ArrayList<Template>();
        for(Map<String,Template> map:indexMap.values()){
            values.addAll(JSON.parseObject(JSON.toJSONString(map.values()),List.class));
        }
        return values;
    }

    public void clean() {
        indexMap.clear();
    }
}
