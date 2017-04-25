package com.collin.controller;

import com.collin.controller.base.BaseController;
import com.collin.entity.Group;
import com.collin.entity.User;
import com.collin.service.ConnDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by collin on 2016/12/9.
 */
@RestController
@RequestMapping("/list")
public class Controller {
    @Autowired
    private ConnDatabase mConnDatabase;

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> checkUser(@RequestBody User user){
        Map map = new HashMap();
        System.out.println("yes");
        map.put("userPw",user.getUserPw());
        System.out.println(user.getUserPw());
        return map;
//        List list = mConnDatabase.checkUser(user.getUserId(), user.getUserPw());
//        if(list == null){
//            return new BaseController().generateFailureMsg("用户名或密码错误！");
//        }else {
//            return new BaseController().generateSuccessMsg(list);
//        }
    }

    @RequestMapping(value = "/addUser", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void addUser(@RequestBody User user){
        System.out.println("add");
        mConnDatabase.addUser(user);
    }

    @RequestMapping(value = "/loadList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> loadList(){
        List list = mConnDatabase.getSequence();
        if(list == null){
            return new BaseController().generateFailureMsg("未加载到用户！");
        }else {
            return new BaseController().generateSuccessMsg(list);
        }
    }

    @RequestMapping(value = "/deleteUser",method = {RequestMethod.GET,RequestMethod.POST})
    public void deleteList (@RequestBody User user){
        System.out.println("delete");
        mConnDatabase.deleteUser(user.getUserId());
    }

    @RequestMapping(value = "/updateUser", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void updateList(@RequestBody User user){
        System.out.println("update");
        System.out.println(user.getUserName());
        mConnDatabase.updateUser(user);
    }

    @RequestMapping(value = "/loadGroups", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> loadGroups(){
        System.out.println("loadGroup");

        List list = mConnDatabase.getAllGroup();
        if(list.isEmpty()){
            return new BaseController().generateFailureMsg("用户名或密码错误！");
        }else {
            return new BaseController().generateSuccessMsg(list);
        }
    }

    @RequestMapping(value = "/loadUsers", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> loadUsers(@RequestBody Group group){
        List list = mConnDatabase.getAllUser(group.getGroupId());
        if(list.isEmpty()){
            return new BaseController().generateFailureMsg("用户名或密码错误！");
        }else {
            return new BaseController().generateSuccessMsg(list);
        }
    }

    @RequestMapping(value = "/loadInitUsers", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> loadInitUsers (){
        List list = mConnDatabase.getInitUsers();
        if(list.isEmpty()){
            return new BaseController().generateFailureMsg("用户名或密码错误！");
        }else {
            return new BaseController().generateSuccessMsg(list);
        }
    }
}
