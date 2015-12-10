package com.barsu.instagram.beans;

import java.util.Date;

/**
 * Created by Kotsuba on 08.12.2015.
 */
public class Comment {
    /*
  *
  "data": [
      {
          "created_time": "1280780324",
          "text": "Really amazing photo!",
          "from": {
              "username": "snoopdogg",
              "profile_picture": "http://images.instagram.com/profiles/profile_16_75sq_1305612434.jpg",
              "id": "1574083",
              "full_name": "Snoop Dogg"
          },
          "id": "420"
      },
      ...
  *
  * */
    private Date created_time;
    private String text;
    private String idUser;
    private String username;
    private String profile_picture;
    private String full_name;
    private int id;

    public Comment(){}

    public Comment(Comment comment) {
        this.created_time = comment.created_time;
        this.text = comment.text;
        this.idUser = comment.idUser;
        this.username = comment.username;
        this.profile_picture = comment.profile_picture;
        this.full_name = comment.full_name;
        this.id = comment.id;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Comment clone(){
        return new Comment(this);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "created_time=" + created_time +
                ", text='" + text + '\'' +
                ", idUser=" + idUser +
                ", username='" + username + '\'' +
                ", profile_picture='" + profile_picture + '\'' +
                ", full_name='" + full_name + '\'' +
                ", id=" + id +
                '}';
    }
}
