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
public class TypewriterController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/room/table/typewriter")
	public Response typewriter_desc(@RequestParam(value = "name", defaultValue = "noname") String gotName) {
		var response_text="Old typewriter..";
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
		UserRepo.messageTW(name,"Airin: Well,hello there,finally noticed that,huh? Anyway,I am Airin,I own this place. Kind of. I am not in the best condition to enforce any rules... But I still can!",0);
		UserRepo.messageTW(name,"Airin: Whatever.You are detective,right? I will try to help as much as possible...But I can't tell much,I wasn't here.",11);
		response_text=response_text+UserRepo.getUserTW(name);
		return new Response(counter.incrementAndGet(), response_text);
	}

	@PutMapping("/room/table/typewriter")
	public Response typewriter_note(@RequestBody Map<String, Object> payload) {
		var response_text="You try to type something ona typewriter.";
		
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
		    response_text="You write : '"+payload.get("content").toString()+"'.";
            response_text=response_text+"Typewriter makes a beeping sound as the new message appiers out of nowhere.";
			UserRepo.messageTW(name,"You: "+payload.get("content").toString(),-1);
		
        }
        else
        {
            response_text="You decide not to write anything and just reset carriage.";
            response_text=response_text+"You can hear something unlocking inside the table.";
        }
        
        return new Response(counter.incrementAndGet(), response_text);
	}

	@PostMapping("/room/table/typewriter")
	public Response typewriter_object() {
		var response_text="You want to use some object on typewriter.Unfortunately, you have none";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@DeleteMapping("/room/table/typewriter")
	public Response typewriter_hit(@RequestParam(value = "name", defaultValue = "noname") String gotName) {
		var response_text="You hit typewriter.It doesn't even move on slightest.You are hurt much more,on the other hand.";

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

		UserRepo.userOpen3(name);
		return new Response(counter.incrementAndGet(), response_text);
	}
}