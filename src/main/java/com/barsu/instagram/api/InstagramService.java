package com.barsu.instagram.api;


import com.barsu.instagram.beans.Comment;
import com.barsu.instagram.beans.Media;
import com.barsu.instagram.beans.User;

import java.util.List;

/**
 * Created by alex on 02.12.2015.
 */
public interface InstagramService {
    List<Media> getMyMedia(int count, int minId, int maxId);
    List<Media> getMyMediaUser(int idUser,int count, int minId, int maxId);
    List<Comment> getComments(int idMedia);
    boolean addComment(int idMedia,String text);
    boolean deleteComment(int idMedia, int idComment);
    User getProfileInfo();
}
