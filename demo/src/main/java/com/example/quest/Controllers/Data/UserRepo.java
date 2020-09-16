package com.example.quest;

import java.util.*;
import com.example.quest.User;

public class UserRepo{

    static Map<String, User>  users=new HashMap<String,User>();

    static String createUser()
    {
        User tmpUs=new User();
        tmpUs.id=Integer.toString(users.size()+1);
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

    static boolean messageTW(String key,String text,Integer event)
    {
        if (!users.containsKey(key))
            return false;
        else 
            if ((event==-1)||(users.get(key).events.charAt(event)=='0'))
            {
                if (event!=-1)
                    users.get(key).events=users.get(key).events.substring(0,event)+"1"+users.get(key).events.substring(event+1);
                users.get(key).typeWriterQueue=users.get(key).typeWriterQueue+text+"\n";
            }
        return true;
    }

    static String getUserTW(String key)
    {
        if (!users.containsKey(key))
            return "";
        else 
            return users.get(key).typeWriterQueue;
    }

}