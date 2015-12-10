package com.barsu.instagram.gui;

import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import static com.barsu.instagram.api.utils.OAuthUtils.*;

/**
 * Created by alex on 02.12.2015.
 */
public class LoginFrame extends JFrame {

    private JFXPanel fxPanel;
    private WebView webView;
    WebEngine webEngine;

    public LoginFrame() {
        super("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    public void initComponents() {
        setPreferredSize(new Dimension(800, 600));
        setLocationByPlatform(true);
        fxPanel = new JFXPanel();
        getContentPane().setLayout(null);
        add(fxPanel);
        fxPanel.setSize(new Dimension(800, 600));
        fxPanel.setLocation(new Point(0, 0));
        pack();
        getContentPane().setPreferredSize(new Dimension(800, 600));
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });


    }

    private void login(String token) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mf = new MainFrame(token);
                mf.setVisible(true);
                LoginFrame.this.dispose();
            }
        });

        try {
            FileWriter writer = new FileWriter("token");
            writer.write(token);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println("Не удалось записать ключ доступа");
        }
    }

    private void initFX(JFXPanel fxPanel) {
        webView = new WebView();
        Group group = new Group();
        Scene scene = new Scene(group);
        fxPanel.setScene(scene);
        group.getChildren().add(webView);
        webView.setMinSize(800, 600);
        webView.setMaxSize(800, 600);
        webEngine = webView.getEngine();
        webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                String token = null;
                if ((token = extractToken(webEngine.getLocation())) != null) {
                    login(token);
                }
            }
        });

        webEngine.loadContent("<A href=" + URL + " style='margin:auto;padding-top:300px;'>Для подверждения прав пройдите по ссылке</A>");
       // webEngine.load(URL);
    }

}
