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
public class CookieController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/room/table/cookies")
	public Response typewriter_desc() {
		var response_text="Box full of fortune cookies. You take one. It says:'";
        var num=(new Random()).nextInt(10);
        switch(num)
        {
            case 0:response_text=response_text+"Don't be lazy,and you won't end like him";
            break;
            case 2:response_text=response_text+"There are more people around you then you think";
            break;
            case 3:response_text=response_text+"Something about sad life and death";
            break;
            case 4:response_text=response_text+"If you will try million times,William would be proud";
            break;
            case 5:response_text=response_text+"Lock 2 has code 9123218";
            break;
            case 6:response_text=response_text+"Not the best way to work,isn't it?";
            break;
            case 7:response_text=response_text+"There is no right or wrong solution";
            break;
            case 8:response_text=response_text+"Punch your way out of this closed room";
            break;
            case 9:response_text=response_text+"42";
            break;
            case 1:response_text=response_text+"She still is in this room";
            break;
            default:break;
        }
		return new Response(counter.incrementAndGet(), response_text);
	}

	@PutMapping("/room/table/cookies")
	public Response typewriter_note(@RequestBody Map<String, Object> payload) {
		var response_text="You try to attach note to cookie bottle.";
        if (payload.keySet().contains("content"))
        {
		    response_text="You write : '"+payload.get("content").toString()+"'.";
            response_text=response_text+"Typewriter makes a beeping sound as the new message appiers out of nowhere.";
        }
        else
        {
            response_text="You decide not to write anything.";
        }
        
        return new Response(counter.incrementAndGet(), response_text);
	}

	@PostMapping("/room/table/cookies")
	public Response typewriter_object() {
		var response_text="You want to use some object on cookie box.Unfortunately, you have none";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@DeleteMapping("/room/table/cookies")
	public Response typewriter_hit() {
		var response_text="You hit box.It shatters,only to be replaced with new one in a blink of eye.";
		return new Response(counter.incrementAndGet(), response_text);
	}
}