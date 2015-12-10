package com.barsu.instagram.api.utils;

/**
 * Created by alex on 02.12.2015.
 */
public class Methods {
    public static final String API = "https://api.instagram.com";
    public static final String V = "/v1";
    public static final String SELF_MEDIA = API+V+"/users/self/media/recent/";
    public static final String COMMENTS_MEDIA = API+V+"media/%s/comments/";
    public static final String MEDIA_USER = API+V+"/users/%s/media/recent/";


}
