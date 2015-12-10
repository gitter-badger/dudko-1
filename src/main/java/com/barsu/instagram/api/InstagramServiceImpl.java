package com.barsu.instagram.api;

import com.barsu.instagram.api.utils.HTTP;
import com.barsu.instagram.api.utils.JSON.Parser;
import com.barsu.instagram.api.utils.JSON.ParserJSON;
import com.barsu.instagram.api.utils.Methods;
import com.barsu.instagram.beans.Comment;
import com.barsu.instagram.beans.Media;
import com.barsu.instagram.beans.User;

import java.util.List;

/**
 * Created by alex on 02.12.2015.
 */
public class InstagramServiceImpl implements InstagramService{

    private String token;

    public InstagramServiceImpl(String token){
        this.token = token;
    }

    @Override
    public List<Media> getMyMedia(int count, int minId, int maxId) {
      return null;
    }

    @Override
    public List<Media> getMyMediaUser(int idUser, int count, int minId, int maxId) {
        return null;
    }

    @Override
    public List<Comment> getComments(int idMedia) {
        return null;
    }

    @Override
    public boolean addComment(int idMedia, String text) {
        return false;
    }

    @Override
    public boolean deleteComment(int idMedia, int idComment) {
        return false;
    }

    @Override
    public User getProfileInfo() {
        String data = HTTP.doGet(Methods.SELF_MEDIA+"?access_token="+token);
        System.out.println(data);
        Parser parser = new ParserJSON();
        User user = null;
        try {
            user = parser.getInfoUser(data);
        } catch (InstagramException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return user;
    }
}
