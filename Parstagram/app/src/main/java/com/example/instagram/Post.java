package com.example.instagram;

import android.graphics.ImageDecoder;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String USER_KEY  = "user";
    public static final String CAPTION_KEY  = "Caption";
    public static final String IMAGE_KEY  = "Image";

    public Post(){
        super();
    }

    public Post(String caption){
        put(CAPTION_KEY, caption);
    }

    public ParseUser getUser(){
        return getParseUser(USER_KEY);
    }

    public String getCaption(){
        return getString(CAPTION_KEY);
    }

    public ParseFile getImage(){
        return getParseFile(IMAGE_KEY);
    }

    public void setCaption(String caption){
        put(CAPTION_KEY, caption);
    }

    public void setUser(ParseUser user){
        put(USER_KEY, user);
    }

    public void setImage(ParseFile image){
        put(IMAGE_KEY, image);
    }

}
