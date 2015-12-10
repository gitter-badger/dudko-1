package com.barsu.instagram.api.utils.JSON;

import com.barsu.instagram.api.InstagramException;
import com.barsu.instagram.beans.*;


import java.util.List;

/**
 * Created by Kotsuba on 08.12.2015.
 */
public interface Parser {
    User getInfoUser(String json)throws InstagramException;
    List<User> getSearchInfoUser(String json)throws InstagramException;
    List<Media> getMedia(String json)throws InstagramException;
    List<Comment> getComments(String json)throws InstagramException;
}
