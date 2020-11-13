package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Hlfe99k3A7gpCfoDX5KlYCB6WHKNuqyOYjcFitDH")
                .clientKey("G1aIcHAVMMgO3JsEWmqRuDiSAbMR2zW8pjZSX3Ot")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
