package com.barsu.instagram.api;

/**
 * Created by Kotsuba on 08.12.2015.
 */
public class InstagramException extends Exception {
    String errMsg;
    public  InstagramException(String errMsg){
        super();
        this.errMsg=errMsg;
    }
    String getErrMsg(){
        return errMsg;
    }
}

