package com.rxjavademo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import static android.content.Context.MODE_PRIVATE;

@Singleton
public class SharedPrefUtils<T> {

    public void setLogin(Context mContext,String username,String loginstatus,String userId,String usertype,String projectlocation,String projectType,
                         String accessToken,String forward){
        SharedPreferences shared = mContext.getSharedPreferences("kolkata_crm", MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("login_status",loginstatus);
        editor.putString("username",username);
        editor.putString("userId",userId);
        editor.putString("userType",usertype);
        editor.putString("projectlocation",projectlocation);
        editor.putString("ProjectType",projectType);
        editor.putString("accessToken",accessToken);
        editor.putString("forward",forward);
        editor.commit();
    }

    public String getlogin(Context context) {
        SharedPreferences shared = context.getSharedPreferences("kolkata_crm", MODE_PRIVATE);
        return shared.getString("login_status","");
    }

    public String getforward(Context context) {
        SharedPreferences shared = context.getSharedPreferences("kolkata_crm", MODE_PRIVATE);
        return shared.getString("forward","");

    }

    public String getToken(Context context) {
        SharedPreferences shared = context.getSharedPreferences("kolkata_crm", MODE_PRIVATE);
        return shared.getString("accessToken","");

    }
    public String getUserid(Context context) {
        SharedPreferences shared = context.getSharedPreferences("kolkata_crm", MODE_PRIVATE);
        return shared.getString("userId","");

    }
    public String getProjectLocation(Context context) {
        SharedPreferences shared = context.getSharedPreferences("kolkata_crm", MODE_PRIVATE);
        return shared.getString("projectlocation","");

    }

    public String getUserType(Context context){
        SharedPreferences shared = context.getSharedPreferences("kolkata_crm", MODE_PRIVATE);
        return shared.getString("userType","");
    }

    public String getProjectType(Context context){
        SharedPreferences shared = context.getSharedPreferences("kolkata_crm", MODE_PRIVATE);
        return shared.getString("ProjectType","");
    }

    public String getUserLogin(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("kolkata_crm",MODE_PRIVATE);
        return sharedPreferences.getString("username","");
    }
    public void clearAppData(Context ctx) {
        SharedPreferences preferences = ctx.getSharedPreferences("kolkata_crm", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}