package com.example.quest;

import java.util.concurrent.atomic.AtomicLong;
import java.util.*;

import com.example.quest.Response;
import com.example.quest.UserRepo;
import com.example.quest.NoteRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackPanelController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/room/dresser/backpanel")
	public Response backpanel_desc(@RequestParam(value = "name", defaultValue = "noname") String gotName) {
        //if opened,recover clues.Otherwise:
		var response_text="You have yet to find way to open it.";
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
		UserRepo.messageTW(name,"Airin: Yeah,there is alot behind this panel.Or at least was.I think,corpse should also be there",6);
		return new Response(counter.incrementAndGet(), response_text);
	}

	@PutMapping("/room/dresser/backpanel")
	public Response backpanel_note(@RequestBody Map<String, Object> payload) {
		var response_text="You try to put note on back panel near the keyhole.";
        if (payload.keySet().contains("content"))
		    response_text="You write a note saying: '"+payload.get("content").toString()+"' and attach it.";
        else
            response_text="You decide not to write anything.Note instantly disappiers";
        return new Response(counter.incrementAndGet(), response_text);
	}

	@PostMapping("/room/dresser/backpanel")
	public Response backpanel_object(@RequestBody Map<String, Object> payload) {
		var response_text="You want to use some object on dresser.Unfortunately, you have none";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@DeleteMapping("/room/dresser/backpanel")
	public Response backpanel_hit() {
		var response_text="You hit back panel.Not very effective.";
		return new Response(counter.incrementAndGet(), response_text);
	}
}