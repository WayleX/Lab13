package com.example.task1;

public class Auth {
    public MyUser login(){
        int random = 10;
        if (random > 5){
            return new MyTwitterUser(new TwitterUser());
        }else{
            return new MyFacebookUser(new FacebookUser());
        }


    }
}
