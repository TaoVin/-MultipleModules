package com.lanchuang.publish.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lanchuang.publish.bean.SystemConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.Map;

/**
 * @author Vincent Tao
 * @date 2019/6/25 9:27
 */
@RequestMapping("/api/public/system")
@Controller
public class SystemConteoller {
    @Autowired
    private SystemConfigBean systemConfigBean;
    @RequestMapping("")
    @ResponseBody
    public JSONObject getSystem(){
        JSONObject result = new JSONObject();
        JSONObject object = new JSONObject();
        JSONArray funs = null;
        try{
            Map<String, Map<String,Boolean>> systemCollection = systemConfigBean.getSubSystem();
            Iterator iterator = systemCollection.entrySet().iterator();
            Iterator functionIterator = null;
            while(iterator.hasNext()){
                Map.Entry moudle = (Map.Entry) iterator.next();
                funs = new JSONArray();
                Map<String,Boolean> function = (Map<String,Boolean>)moudle.getValue();
                functionIterator = function.entrySet().iterator();
                while(functionIterator.hasNext()){
                    Map.Entry item =( Map.Entry) functionIterator.next();
                    Boolean  judge =(Boolean)item.getValue();
                    if(judge){
                        funs.add(item.getKey());
                    }
                }
                object.put(moudle.getKey().toString(),funs);
            }
            result.put("data",object);
        }catch(Exception e){

            e.printStackTrace();
        }
        return result;
    }
}

