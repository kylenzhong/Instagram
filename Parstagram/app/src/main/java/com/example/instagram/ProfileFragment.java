package com.example.instagram;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends StoryFragment {
    @Override
    public void getPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.USER_KEY);
        query.whereEqualTo(Post.USER_KEY, ParseUser.getCurrentUser());
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> objects, ParseException e) {
                if(e != null){
                    Log.e(tag, "problem finding posts", e);
                    return;
                }
                posts.addAll(objects);
                for(int i =0; i<posts.size();i++){
                    System.out.println(posts.get(i).getCaption().toString());
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
