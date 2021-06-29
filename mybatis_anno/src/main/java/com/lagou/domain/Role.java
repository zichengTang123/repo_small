package com.lagou.domain;

import java.io.Serializable;

public class Role implements Serializable {

    private int id;
    private String roleDesc;
    private String rolename;

    //private List<User> userList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleDesc='" + roleDesc + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
