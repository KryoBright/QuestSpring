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
public class DresserController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/room/dresser")
	public Response dresser_desc() {
		var response_text="A regular dresser it has dresses and suit inside.There is a keyhole on back of it";

		return new Response(counter.incrementAndGet(), response_text);
	}

	@PutMapping("/room/dresser")
	public Response dresser_note(@RequestBody Map<String, Object> payload) {
		var response_text="You try to put note on door of dresser.";
        if (payload.keySet().contains("content"))
		    response_text="You write a note saying: '"+payload.get("content").toString()+"' and attach it";
        else
            response_text="You decide not to write anything.Note instantly disappiers";
        return new Response(counter.incrementAndGet(), response_text);
	}

	@PostMapping("/room/dresser")
	public Response dresser_object(@RequestBody Map<String, Object> payload) {
		var response_text="You want to use some object on dresser.Unfortunately, you have none";
        if (payload.keySet().contains("object"))
            if (payload.get("object")=="key")//and has key
		        response_text="You put a key in keyhole. Hidden panel of dresser silently opens.";
            else
                response_text="You fail to do whatever you tried.";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@DeleteMapping("/room/dresser")
	public Response dresser_hit() {
		var response_text="You hit dresser.Not very effective.";
		return new Response(counter.incrementAndGet(), response_text);
	}
}