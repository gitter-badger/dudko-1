package com.barsu.instagram.beans;

/**
 * Created by Kotsuba on 07.12.2015.
 */
public class User implements Cloneable {
    /*
    *
    *
*{
    "data": {
        "id": "1574083",
        "username": "snoopdogg",
        "full_name": "Snoop Dogg",
        "profile_picture": "http://distillery.s3.amazonaws.com/profiles/profile_1574083_75sq_1295469061.jpg",
        "bio": "This is my bio",
        "website": "http://snoopdogg.com",
        "counts": {
            "media": 1320,
            "follows": 420,
            "followed_by": 3410
        }
}

          "data": [{
        "username": "jack",
        "first_name": "Jack",
        "profile_picture": "http://distillery.s3.amazonaws.com/profiles/profile_66_75sq.jpg",
        "id": "66",
        "last_name": "Dorsey"
    },
    {
        "username": "sammyjack",
        "first_name": "Sammy",
        "profile_picture": "http://distillery.s3.amazonaws.com/profiles/profile_29648_75sq_1294520029.jpg",
        "id": "29648",
        "last_name": "Jack"
    },
    {
    *
    *
    *
    * */
    public User(){}
    public User(User user) {
        this.username = user.username;
        this.first_name = user.first_name;
        this.last_name = user.last_name;
        this.profile_picture = user.profile_picture;
        this.id = user.id;
        this.media = user.media;
        this.follows = user.follows;
        this.followed_by = user.followed_by;
    }

    private String username;
    private String first_name;
    private String last_name;
    private String profile_picture;
    private String id;

    private int media;
    private int follows;
    private int followed_by;

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    public void setFollowed_by(int followed_by) {
        this.followed_by = followed_by;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public String getId() {
        return id;
    }

    public int getMedia() {
        return media;
    }

    public int getFollows() {
        return follows;
    }

    public int getFollowed_by() {
        return followed_by;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", profile_picture='" + profile_picture + '\'' +
                ", id=" + id +
                ", media=" + media +
                ", follows=" + follows +
                ", followed_by=" + followed_by +
                '}';
    }
    @Override
    public User clone(){
        return new User(this);
    }
}
