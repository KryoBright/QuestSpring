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
public class Section3Controller {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/room/table/sections/3")
	public Response sec3_desc(@RequestBody Map<String, Object> payload) {
		var response_text="Lower section under the table.It has word lock for very long words.";
        //retrive "if opened" from database
        if (payload.keySet().contains("key"))
		{
			if (payload.get("key")=="key_encrypted")
			{	
            //retrive clues from database
			}
			else
			{
				response_text=response_text+"You enter your key.It is invalid.";
			}
		}

		return new Response(counter.incrementAndGet(), response_text);
	}

	@PutMapping("/room/table/sections/3")
	public Response sec3_note(@RequestBody Map<String, Object> payload) {
		var response_text="";
		if (payload.keySet().contains("key"))
		{
			if (payload.get("key")=="key_encrypted")
			{	
				if (payload.keySet().contains("content"))
					response_text="You write a note saying: '"+payload.get("content").toString()+"' and put it inside.";
				else
					response_text="You decide not to write anything.Note instantly disappiers";
				
			}
			else
			{
				if (payload.keySet().contains("content"))
					response_text="You write a note saying: '"+payload.get("content").toString()+"' and attach it to the edge of section.";
				else
					response_text="You decide not to write anything.Note instantly disappiers";
			}
		}
        return new Response(counter.incrementAndGet(), response_text);
	}

	@PostMapping("/room/table/sections/3")
	public Response sec3_object() {
		var response_text="You want to use some object on section.Unfortunately, you have none";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@DeleteMapping("/room/table/sections/3")
	public Response sec3_hit() {
		var response_text="You hit section.It makes metallic noise,but nothing else happens.";
		return new Response(counter.incrementAndGet(), response_text);
	}
}