package com.barsu.instagram.gui;

import com.barsu.instagram.api.InstagramService;
import com.barsu.instagram.beans.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by alex on 02.12.2015.
 */
public class MainFrame extends JFrame implements ActionListener {


    private String token;
    private InstagramService instagramService;
    private JMenuItem exitMenu;
    private JMenuItem logoutMenu;
    private JMenuItem selfProfile;
    private ProfileViewPanel profilePanel;

    public MainFrame(String token) {
        super("BarSUInsta");
        this.token = token;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponent();

    }


    private void initComponent() {

        exitMenu = new JMenuItem("Выход");
        exitMenu.addActionListener(this);
        logoutMenu = new JMenuItem("Сменить аккаунт");
        logoutMenu.addActionListener(this);
        selfProfile = new JMenuItem("Профиль");

        JMenuBar menuBar= new JMenuBar();


        JMenu about = new JMenu("Аккаунт");
        about.add(selfProfile);
        about.add(logoutMenu);
        menuBar.add(about);


        menuBar.add(exitMenu);




        setJMenuBar(menuBar);
        setPreferredSize(new Dimension(800, 600));


        setLocationByPlatform(true);

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getSource()==logoutMenu) {
            logoutButtonAction();
        } else if (e.getSource()== exitMenu){
            System.exit(0);
        } else if (e.getSource()== selfProfile){
            User user = instagramService.getProfileInfo();
            profilePanel.setUser(user);
            setContentPane(profilePanel);

        }
    }

    private void logoutButtonAction() {
        File file = new File("token");
        if (file.exists() && file.isFile())
            file.delete();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginFrame lg = new LoginFrame();
                lg.setVisible(true);
            }

        });
        dispose();

    }


}
