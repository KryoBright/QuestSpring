package com.example.quest;

import java.util.concurrent.atomic.AtomicLong;
import java.util.*;

import com.example.quest.Response;
import com.example.quest.NoteRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CluesInitializer {

	private final AtomicLong counter = new AtomicLong();

	@PostMapping("/clues/init")
	public Response initial() {
        NoteRepo.createClue("backpanel","There is no more than 1 person in this room in any given moment.");
        NoteRepo.createClue("sec1","Airin is as dead as you.");
        NoteRepo.createClue("sec2","Culpit may or may not be here.");
        NoteRepo.createClue("sec3","Dead person had no corpse");
		var response_text="Initialized successfully";
		return new Response(counter.incrementAndGet(), response_text);
	}

}