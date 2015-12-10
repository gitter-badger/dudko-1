package com.barsu.instagram.gui;

import com.barsu.instagram.beans.User;

import javax.swing.*;

/**
 * Created by alex on 02.12.2015.
 */
public class ProfileViewPanel extends JPanel {

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user=null;

    public ProfileViewPanel(){
        super();
        initComponent();
    }

    private void initComponent() {

    }

    public ProfileViewPanel(User user){
        super();
        this.user=user;
    }



}
