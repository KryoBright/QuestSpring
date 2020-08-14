package com.example.quest;

import java.util.concurrent.atomic.AtomicLong;

import com.example.quest.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/room")
	public Response room_desc() {
		var response_text="You are in this room.There has been a murder here.You are the DETECTIVE.There is window,table and dresser.";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@PutMapping("/room")
	public Response room_nonote() {
		var response_text="You try to put note here.Unfortunately,there is no place for it.You better be more specific in future.";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@PostMapping("/room")
	public Response room_noobject() {
		var response_text="You want to use some object on room.It is ineffective,because generally room is just empty space.";
		return new Response(counter.incrementAndGet(), response_text);
	}

	@DeleteMapping("/room")
	public Response room_no() {
		var response_text="You try to hit room.Unfortunately,there is no solid object to hit.";
		return new Response(counter.incrementAndGet(), response_text);
	}
}