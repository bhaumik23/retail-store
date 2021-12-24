package com.bhaumik.retailstore.bean;

import java.util.List;

/**
 * @author admin
 * This is Bill Request object which have user and brought items data
 */
public class BillRequest {
    private List<Item> items;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
