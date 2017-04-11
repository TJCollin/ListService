package com.collin.controller.base;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by collin on 2016/12/9.
 */
public class BaseController {
    public Map<String, Object> generateSuccessMsg(List list){
        System.out.println("Map" + list.toString());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", list);
        map.put("success", true);
        return map;
    }

    public Map<String, Object> generateFailureMsg(String msg){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", msg);
        map.put("success", false);
        return map;
    }
}
