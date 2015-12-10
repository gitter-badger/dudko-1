package com.barsu.instagram.app;

import com.barsu.instagram.api.InstagramException;
import com.barsu.instagram.api.InstagramService;
import com.barsu.instagram.api.InstagramServiceImpl;
import com.barsu.instagram.api.utils.HTTP;
import com.barsu.instagram.api.utils.Methods;
import com.barsu.instagram.beans.*;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 02.12.2015.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        InstagramService service = new InstagramServiceImpl("1407815566.4121277.feefe4d1f4c8488ebb2df6e98aa7a292");
        User user = service.getProfileInfo();
        System.out.println(user);
             /*System.out.println(Methods.SELF_MEDIA);
             System.out.println(HTTP.doPost(Methods.SELF_MEDIA,data));*/





    }
}
