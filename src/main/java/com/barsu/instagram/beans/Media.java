package com.barsu.instagram.beans;

import java.util.Date;
import java.util.List;

/**
 * Created by Kotsuba on 08.12.2015.
 */
public class Media implements Cloneable {
        private int id;
        private String Image_low;
        private String Image_thumb;
        private String Image_std;
        private String link;
        private User user;
        private Date created_time;
        private String text;
        private List<String> tags;
    public Media(){}

    public Media(Media media) {
        this.id = media.id;
        this.Image_low = media.Image_low;
        this.Image_thumb = media.Image_thumb;
        this.Image_std = media.Image_std;
        this.link = media.link;
        this.user = media.user;
        this.created_time = media.created_time;
        this.text = media.text;
        this.tags = media.tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_low() {
        return Image_low;
    }

    public void setImage_low(String image_low) {
        Image_low = image_low;
    }

    public String getImage_thumb() {
        return Image_thumb;
    }

    public void setImage_thumb(String image_thumb) {
        Image_thumb = image_thumb;
    }

    public String getImage_std() {
        return Image_std;
    }

    public void setImage_std(String image_std) {
        Image_std = image_std;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    @Override
    public Media clone(){
        return new Media(this);
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", Image_low='" + Image_low + '\'' +
                ", Image_thumb='" + Image_thumb + '\'' +
                ", Image_std='" + Image_std + '\'' +
                ", link='" + link + '\'' +
                ", user=" + user +
                ", created_time=" + created_time +
                ", text='" + text + '\'' +
                ", tags=" + tags +
                '}'+"\n";
    }
}
