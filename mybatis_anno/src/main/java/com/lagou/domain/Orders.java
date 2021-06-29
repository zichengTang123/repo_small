package com.lagou.domain;

import java.io.Serializable;

public class Orders implements Serializable {

    private int id;
    private String ordertime;
    private Double total;
    private int uid;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*表示当前订单属于哪个用户*/
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ordertime='" + ordertime + '\'' +
                ", total=" + total +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }
}
