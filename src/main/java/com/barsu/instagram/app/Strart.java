package com.barsu.instagram.app;

import com.barsu.instagram.gui.LoginFrame;
import com.barsu.instagram.gui.MainFrame;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by alex on 02.12.2015.
 */
public class Strart {
    public static void main(String[] args) {
        String token = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("token"));
            token = reader.readLine();
            reader.close();
        } catch (IOException e) {
        }

        if (token != null) {
            final String TOKEN = token;
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    MainFrame mf = new MainFrame(TOKEN);
                    mf.setVisible(true);
                }
            });

        } else {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    LoginFrame lf = new LoginFrame();
                    lf.setVisible(true);
                }
            });
        }


    }
}
