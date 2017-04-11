package com.collin.service;

import com.collin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by collin on 2016/12/9.
 */
@Service
public class ConnDatabase {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List checkUser(String userId, String password){
        String sql = "select * from tb_user where id = \'" + userId + "\'" +"and password = \'" + password + "\'";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        if(list.isEmpty()){
            return null;
        }else {
            return list;
        }
    }

    public List getSequence() {
        String sql = "select id, password, jsondata ->> \'name\' as name, jsondata ->> \'office\' as office, jsondata->>\'title\' as title, jsondata->>\'project\' as project, jsondata->>\'openinghours\' as openinghours, jsondata->>\'email\' as email, jsondata->>\'subject\' as subject from tb_user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    public void addUser(User user){
        String userId = user.getUserId();
        String userName = user.getUserName();
        String userOffice = user.getUserOffice();
        String userSubject = user.getUserSubject();
        String userProject = user.getUserProject();
        String userTime = user.getUserTime();
        String userEmail = user.getUserEmail();
        String userTitle = user.getUserTitle();
        String userPw = user.getUserPw();
        String newData = "{" +
                "\"name\":" + "\"" + userName + "\"" + ","+
                "\"office\":"+ userOffice + ","+
                "\"subject\":" + "\"" + userSubject + "\"" + ","+
                "\"project\":" + "\"" + userProject + "\"" + ","+
                "\"openinghours\":" + "\"" + userTime + "\"" + ","+
                "\"email\":" + "\"" + userEmail + "\"" + ","+
                "\"title\":" + "\"" + userTitle + "\"" +
                "}";
        String sql = "insert into tb_user values (\'" + userId + "\'" + "," +
                "\'" + userPw + "\'" + "," +
                "\'" + newData + "\'" + ")";
        System.out.println(sql);
        jdbcTemplate.execute(sql);
    }

    public void deleteUser(String userId){
        String sql = "delete from tb_user where id = \'" + userId + "\'";
        jdbcTemplate.execute(sql);
    }

    public void updateUser(User user){
        String userId = user.getUserId();
        String userName = user.getUserName();
        String userOffice = user.getUserOffice();
        String userSubject = user.getUserSubject();
        String userProject = user.getUserProject();
        String userTime = user.getUserTime();
        String userEmail = user.getUserEmail();
        String userTitle = user.getUserTitle();
        String newData = "{" +
                "\"name\":" + "\"" + userName + "\"" + ","+
                "\"office\":"+ userOffice + ","+
                "\"subject\":" + "\"" + userSubject + "\"" + ","+
                "\"project\":" + "\"" + userProject + "\"" + ","+
                "\"openinghours\":" + "\"" + userTime + "\"" + ","+
                "\"email\":" + "\"" + userEmail + "\"" + ","+
                "\"title\":" + "\"" + userTitle + "\"" +
                "}";
        String sql = "update tb_user set jsondata = \'" + newData +"\'"+ "where id = \'" + userId + "\'";
        System.out.println(sql);
        jdbcTemplate.execute(sql);
    }

    public List getAllGroup() {
        String sql = "select string_agg(tb_user.jsondata ->> \'name\', \',\') as userName, max(tb_group.name) as groupName, tb_conn.groupid as groupId from tb_user, tb_group, tb_conn where tb_conn.userid = tb_user.id and tb_conn.groupid = tb_group.id group by groupId";
        System.out.println("getAllGroup");
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    public List getAllUser(String groupId) {
        String sql = "select id, jsondata ->> \'name\' as name, FALSE as checked from tb_user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        String sql1 = "select tb_user.id, jsondata ->> \'name\' as name, FALSE as checked from tb_user, tb_group, tb_conn where tb_conn.userid = tb_user.id and tb_conn.groupid = tb_group.id and tb_group.id = " + groupId;
        List<Map<String, Object>> list1 = jdbcTemplate.queryForList(sql1);
//        List<Map<String, Object>> list2 = list;
//        list2.retainAll(list1);
        for(Map<String, Object> map : list1){
            for(Map<String, Object> map1 : list){
                if (map1.get("id").equals(map.get("id"))){
                    map1.put("checked",true);
                }
            }
        }
        System.out.println(list.toString());
        System.out.println(list1.toString());
//        System.out.println(list2.toString());
        return list;
    }

    public List getInitUsers (){
        String sql = "select id, jsondata ->> \'name\' as name, FALSE as checked from tb_user";
        String sql1 = "update tb_conn set groupId = groupId and userId = user Id" + "" + "";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }


}
