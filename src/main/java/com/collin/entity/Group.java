package com.collin.entity;

import java.io.Serializable;

/**
 * Created by collin on 2016/12/11.
 */
public class Group implements Serializable{
    private static final long serialVersionUID = 4236265357506873901L;
    private String groupId;
    private String groupName;

    public Group(String groupId) {
        this.groupId = groupId;
    }

    public Group(){}

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
