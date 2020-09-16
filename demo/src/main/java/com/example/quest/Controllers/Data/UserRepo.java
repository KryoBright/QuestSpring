package com.example.quest;

import java.util.*;
import com.example.quest.User;

public class UserRepo{

    static Map<String, User>  users=new HashMap<String,User>();

    static String createUser()
    {
        User tmpUs=new User();
        tmpUs.id=Integer.toString(users.size());
        users.put(tmpUs.id,tmpUs);
        return tmpUs.id;
    }

    static String createUser(String key)
    {
        User tmpUs=new User();
        tmpUs.id=key;
        if (!users.containsKey(key))
            users.put(key,tmpUs);
        return tmpUs.id;
    }

    static boolean userHasKey(String key)
    {
        if (!users.containsKey(key))
            return false;
        else 
            return users.get(key).hasKey;
    }
    
    static boolean userBrokeWindow(String key)
    {
        if (!users.containsKey(key))
            return false;
        else 
            return users.get(key).brokeWindow;
    }

    static boolean giveUserKey(String key)
    {
        if (!users.containsKey(key))
            return false;
        else 
            users.get(key).hasKey=true;
        return true;
    }

    static boolean changeUserWindowState(String key)
    {
        if (!users.containsKey(key))
            return false;
        else 
            users.get(key).brokeWindow=!users.get(key).brokeWindow;
        return true;
    }

    static boolean messageTW(String key,String text)
    {
        if (!users.containsKey(key))
            return false;
        else 
            users.get(key).typeWriterQueue=users.get(key).typeWriterQueue+text+"\n";
        return true;
    }

    static boolean userOpened1(String key)
    {
        if (!users.containsKey(key))
            return false;
        else 
            return users.get(key).sec1;
    }

    static boolean userOpened3(String key)
    {
        if (!users.containsKey(key))
            return false;
        else 
            return users.get(key).sec3;
    }

    static boolean userOpen1(String key)
    {
        if (!users.containsKey(key))
            return false;
        else 
        {
            users.get(key).sec1=true;
            return true;
        }
    }

    static boolean userOpen3(String key)
    {
        if (!users.containsKey(key))
            return false;
        else 
        {
            users.get(key).sec3=true;
            return true;
        }
    }
}