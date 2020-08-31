package com.example.quest;

import java.util.*;
import com.example.quest.Note;

public class NoteRepo{

    static Map<Integer, Note>  notes=new HashMap<Integer,Note>();

    static Integer createNote()
    {
        Note tmpUs=new Note();
        tmpUs.id=notes.size();
        tmpUs.text="Empty clue.Really? Reverse engeneering is not THAT good and fair.";
        tmpUs.isClue=true;
        tmpUs.object="Air.Really,how did you get there?";

        notes.put(tmpUs.id,tmpUs);
        return tmpUs.id;
    }

    static Integer createClue(String obj,String txt)
    {
        Note tmpUs=new Note();
        tmpUs.id=notes.size();
        tmpUs.text=txt;
        tmpUs.isClue=true;
        tmpUs.object=obj;
        
        notes.put(tmpUs.id,tmpUs);
        return tmpUs.id;
    }

    static Integer createNote(String obj,String txt,String ownr)
    {
        Note tmpUs=new Note();
        tmpUs.id=notes.size();
        tmpUs.text=txt;
        tmpUs.isClue=true;
        tmpUs.object=obj;
        tmpUs.owner=ownr;
        
        notes.put(tmpUs.id,tmpUs);
        return tmpUs.id;
    }

    static List<String> getAllNotesOrClues(String obj,String ownr)
    {
        List<String> a=new ArrayList<String>();
        for (Note n:notes)
        {
            String t="";
            if (n.object==obj)
            {
                if(n.isClue)
                {
                    t="Clue: "+n.text+" \n";
                }
                else
                {
                    if(n.owner==ownr)
                    {
                        t="Your Note: "+n.text+" \n";
                    }
                }
            }
            if (t!="")
            {
                a.add(t);
            }
        }
        return a;
    }

}