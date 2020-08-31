package com.example.quest;

import java.util.concurrent.atomic.AtomicLong;
import java.util.*;

import com.example.quest.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WindowController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/room/window")
	public Response window_desc(@RequestBody Map<String, Object> payload) {
		var response_text="The window.It looks like a hole in a wall with some darkish glass in it.";
        if (true)
            response_text=response_text+"Through broken window you can see nothing. It's not even empty space,it's just nothing.";
        else
            response_text=response_text+"It is impossible to see anything throgh glass. It feels as if you were staring at the wall";
		var name="";
        if (payload.keySet().contains("name"))
		{
			name=UserRepo.createUser(payload.get("name").toString());
		}
		else
		{
			name=UserRepo.createUser();
			response_text=response_text+"You are known as '"+name+"'.Please,pass you name as JSON attribute in future.";
		}
		List<String> notes=NoteRepo.getAllNotesOrClues("window",name);
		return new Response(counter.incrementAndGet(), response_text,name,notes);
	}

	@PutMapping("/room/window")
	public Response window_note(@RequestBody Map<String, Object> payload) {
		var response_text="You try to atttach note to the windows edge.";
        var name="";
        if (payload.keySet().contains("name"))
		{
			name=UserRepo.createUser(payload.get("name").toString());
		}
		else
		{
			name=UserRepo.createUser();
			response_text=response_text+"You are known as '"+name+"'.Please,pass you name as JSON attribute in future.";
		}

        if (payload.keySet().contains("content"))
		{
		    response_text="You write a note saying: '"+payload.get("content").toString()+"' and attach it.";
			NoteRepo.createNote("window",payload.get("content").toString(),name);
		}
        else
            response_text="You decide not to write anything.Note instantly disappiers";
		
        return new Response(counter.incrementAndGet(), response_text,name);
	}

	@PostMapping("/room/window")
	public Response window_object() {
		var response_text="You want to use some object on window.Unfortunately, you have none";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@DeleteMapping("/room/window")
	public Response window_hit() {
		var response_text="";
        if (!true)
        {
            response_text="You hit window with all your strength.It shatters.Now there is a considerable hole in it.";
            //smashed=true;
        }
        else
        {
            response_text="You stick you hand into window.Suddenly,glass starts to regenerate and painfully cuts your hand.You barely manage to escape";
            //smashed=false;
        }
		return new Response(counter.incrementAndGet(), response_text);
	}
}