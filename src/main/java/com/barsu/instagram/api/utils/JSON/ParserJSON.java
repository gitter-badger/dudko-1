package com.barsu.instagram.api.utils.JSON;

import com.barsu.instagram.api.InstagramException;
import com.barsu.instagram.beans.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kotsuba on 07.12.2015.
 */
public class ParserJSON implements Parser{
    /*
    * Get information about the owner of the access_token.
    * */

    public User getInfoUser(String json)throws InstagramException {
        User user=new User();
        JSONObject jsonObject = new JSONObject(json);
        if(isMetaCode(jsonObject)) {
            JSONObject data = jsonObject.getJSONObject("data");
            user.setId(data.getInt("id"));
            user.setUsername(data.getString("username"));
            user.setProfile_picture(data.getString("profile_picture"));

            JSONObject counts = jsonObject.getJSONObject("data").getJSONObject("counts");
            user.setMedia(counts.getInt("media"));
            user.setFollows(counts.getInt("follows"));
            user.setFollowed_by(counts.getInt("followed_by"));
        }
        return user;
    }
    /*
    * Get a list of users matching the query.
    * */
    @Override
    public List<User> getSearchInfoUser(String json)throws InstagramException{
        List<User> userList=new ArrayList<User>();
        User user=new User();
        JSONObject jsonObject=new JSONObject(json);
        if(isMetaCode(jsonObject)) {
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                user.setId(data.getInt("id"));
                user.setUsername(data.getString("username"));
                user.setFirst_name(data.getString("first_name"));
                user.setLast_name(data.getString("last_name"));
                user.setProfile_picture("profile_picture");
                userList.add(user.clone());
            }
        }
        return userList;
    }
    /*
    * Get the most recent media published by the owner of the access_token.
    * */
    @Override
    public List<Media> getMedia(String json)throws InstagramException{
        Media media = new Media();
        List<Media> mediaList = new ArrayList<Media>();
        JSONObject jsonObject = new JSONObject(json);
        if(isMetaCode(jsonObject)){
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
               //parseInt �� ��������
               // media.setId(Integer.valueOf(data.getString("id")));
                media.setCreated_time(new Date(data.getLong("created_time")));
                media.setLink(data.getString("link"));
                User user = new User();
                JSONObject userinfo = data.getJSONObject("user");
                user.setUsername(userinfo.getString("username"));
                user.setProfile_picture(userinfo.getString("profile_picture"));
                user.setId(userinfo.getInt("id"));
                media.setUser(user);

                JSONObject img = data.getJSONObject("images");

                JSONObject low_resolution=img.getJSONObject("low_resolution");
                media.setImage_low(low_resolution.getString("url"));

                JSONObject standard_resolution=img.getJSONObject("standard_resolution");
                media.setImage_std(standard_resolution.getString("url"));

                JSONObject thumbnail=img.getJSONObject("thumbnail");
                media.setImage_thumb(thumbnail.getString("url"));
               //�� ���������� "�aption" ��� JSONObject
               // media.setText(data.getJSONObject("caption").getString("text"));


                JSONArray tags = data.getJSONArray("tags");
                List<String> tag = new ArrayList<String>();
                    for (int j = 0; j < tags.length(); j++) {
                        tag.add(tags.getString(j));
                    }
                    media.setTags(tag);
                mediaList.add(media.clone());
            }
        }
        return mediaList;
    }
    /*
    * Get a list of recent comments on a media object.
    * The public_content permission scope is required to get comments for a media that does not belong to the owner of the access_token.
    * */
    @Override
    public List<Comment> getComments(String json)throws InstagramException{
        List<Comment> commentList=new ArrayList<Comment>();
        Comment comment=new Comment();
        JSONObject jsonObject=new JSONObject(json);
        if(isMetaCode(jsonObject)){
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject data = jsonArray.getJSONObject(i);
                comment.setId(data.getInt("id"));
                comment.setText(data.getString("text"));
                comment.setCreated_time(new Date(data.getLong("created_time")));

                JSONObject from = data.getJSONObject("from");
                comment.setProfile_picture(from.getString("profile_picture"));
                comment.setUsername(from.getString("username"));
                comment.setIdUser(from.getInt("id"));
                comment.setFull_name(from.getString("full_name"));

                commentList.add(comment.clone());
            }
        }
        return commentList;
    }
    private boolean isMetaCode(JSONObject jsonObject)throws InstagramException{
        int meta=jsonObject.getJSONObject("meta").getInt("code");
        if(meta!=200){
            String errMsg=jsonObject.getJSONObject("meta").getString("error_message");
            throw new InstagramException(errMsg);
        }
        else
            return true;
    }
}
