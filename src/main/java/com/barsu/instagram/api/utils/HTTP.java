package com.barsu.instagram.api.utils;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;


/**
 * Created by alex on 02.12.2015.
 */
public class HTTP {
    public static String doGet(String url) {

        HttpClient httpclient = new DefaultHttpClient();

        HttpGet httpget = new HttpGet(url);


        String responseString = new String();
        try {

            HttpResponse response = httpclient.execute(httpget);


            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                responseString = EntityUtils.toString(responseEntity);
            }

        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }
        return responseString;
    }


    public static String doPost(String url, List<NameValuePair> data) {
        HttpClient httpclient = new DefaultHttpClient();

        HttpPost httppost = new HttpPost(url);

        String responseString = new String();
        try {
            if (data != null)
                httppost.setEntity(new UrlEncodedFormEntity(data));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity responseEntity = response.getEntity();
            System.out.println(response.getStatusLine().getStatusCode());
            if (responseEntity != null) {
                responseString = EntityUtils.toString(responseEntity);
            }

        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }
        return responseString;
    }


}
