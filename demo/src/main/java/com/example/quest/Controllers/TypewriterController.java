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

	@GetMapping("/room/typewriter")
	public Response typewriter_desc() {
		var response_text="Old typewriter. One single phrase typed on top of the page:'dQ_4w9WgXcQ 2 3 w r'. It doesn't seem as something understandable,but is still somewhat familiar";

		return new Response(counter.incrementAndGet(), response_text);
	}

	@PutMapping("/room/typewriter")
	public Response typewriter_note(@RequestBody Map<String, Object> payload) {
		var response_text="You try to type something ona typewriter.";
        if (payload.keySet().contains("content"))
        {
		    response_text="You write : '"+payload.get("content").toString()+"'.";
            response_text=response_text+"Typewriter makes a beeping sound as the new message appiers out of nowhere.";
        }
        else
        {
            response_text="You decide not to write anything and just reset carriage.";
            response_text=response_text+"You can hear something unlocking inside the table.";
        }
        
        return new Response(counter.incrementAndGet(), response_text);
	}

	@PostMapping("/room/typewriter")
	public Response typewriter_object() {
		var response_text="You want to use some object on typewriter.Unfortunately, you have none";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@DeleteMapping("/room/typewriter")
	public Response typewriter_hit() {
		var response_text="You hit typewriter.It doesn't even move on slightest.You are hurt much more,on the other hand.";
		return new Response(counter.incrementAndGet(), response_text);
	}
}