package com.barsu.instagram.api.utils;

/**
 * Created by alex on 02.12.2015.
 */
public class OAuthUtils {

    public static final String CLIENT_ID = "41212776c7dd46e48754928a1772e8a7";
    public static final String REDIRECT_URL = "http://localhost";
    public static final String URL = "https://instagram.com/oauth/authorize/?" +
            "client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URL +
            "&response_type=token";

    public static String extractToken(String url){
        String token = null;
        if (url.startsWith(REDIRECT_URL + "/#access_token=")) {
            token = url.substring(url.lastIndexOf('=') + 1, url.length());
        }
        return  token;
    }
}
