package com.example.quest;

import java.util.concurrent.atomic.AtomicLong;
import java.util.*;

import com.example.quest.Response;
import com.example.quest.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetectiveController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/room/detective")
	public Response detective_desc(@RequestBody Map<String, Object> payload) {
		var response_text="You are the DETECTIVE.You generally look fine,most poeple would describe it as average.Not really an important person at all.";
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
		return new Response(counter.incrementAndGet(), response_text,name);
	}

	@PutMapping("/room/detective")
	public Response detective_note(@RequestBody Map<String, Object> payload) {
		var response_text="You try to put note on yourself.";
        if (payload.keySet().contains("content"))
		    response_text="You write a note saying: '"+payload.get("content").toString()+"' and attach it to your jacket";
        else
            response_text="You decide not to write anything.Note instantly disappiers";
		
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

        return new Response(counter.incrementAndGet(), response_text,name);
	}

	@PostMapping("/room/detective")
	public Response detective_object() {
		var response_text="You want to use some object on yourself.Unfortunately, you have none";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@DeleteMapping("/room/detective")
	public Response detective_hit() {
		var response_text="You hit yourself.It is painful, but it's nothing compared to feeling useless doing your job so poorly";
		return new Response(counter.incrementAndGet(), response_text);
	}
}