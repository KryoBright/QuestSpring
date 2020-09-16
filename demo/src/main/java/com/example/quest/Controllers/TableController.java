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
public class TableController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/room/table")
	public Response table_desc(@RequestBody Map<String, Object> payload) {
		var response_text="This is the table.Probably the most ordinary one.There is typewriter on top of it,box of fortune cookies and 3 sections underneath";
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
		List<String> notes=NoteRepo.getAllNotesOrClues("table",name);
		return new Response(counter.incrementAndGet(), response_text,name,notes);
	}

	@PutMapping("/room/table")
	public Response table_note(@RequestBody Map<String, Object> payload) {
		var response_text="You try to atttach note to the tables edge.";
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
			NoteRepo.createNote("table",payload.get("content").toString(),name);
		}
        else
            response_text="You decide not to write anything.Note instantly disappiers";
		
        return new Response(counter.incrementAndGet(), response_text,name);
	}

	@PostMapping("/room/table")
	public Response table_object() {
		var response_text="You want to use some object on table.Unfortunately, you have none";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@DeleteMapping("/room/table")
	public Response table_hit(@RequestParam(value = "name", defaultValue = "noname") String gotName) {
		
		var response_text="You hit table.It makes sound as if something was breaking inside it,but nothing changes.";
		
		var name="";
        if (!gotName.equals("noname"))
		{
			name=UserRepo.createUser(gotName);
		}
		else
		{
			name=UserRepo.createUser();
			response_text=response_text+"You are known as '"+name+"'.Please,pass you name as JSON attribute in future.";
		}

		UserRepo.userOpen1(name);
		return new Response(counter.incrementAndGet(), response_text);
	}
}