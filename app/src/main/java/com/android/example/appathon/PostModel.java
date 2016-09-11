package com.android.example.appathon;

/**
 * Created by Raju Kaushik on 9/11/2016.
 */

import java.util.ArrayList;

public class PostModel
{
    public String post_name, post_text, post_tag,post_catid,user_name ;



    public PostModel(String post_name, String post_text, String user_name, String post_tag, String post_catid)
    {

        this.post_name = post_name;
        this.post_text = post_text;
        this.user_name = user_name;


        this.post_tag = post_tag;
        this.post_catid = post_catid;

    }
}