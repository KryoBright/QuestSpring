package com.example.quest;
import java.util.*;

public class Response {

	private final long id;
	private final String content;
	private final String name;
	private List<String> notes=new ArrayList<String>();

	public Response(long id, String content,String name,List<String> notes) {
		this.id = id;
		this.content = content;
		this.name=name;
		this.notes=notes;
	}

	public Response(long id, String content,String name) {
		this.id = id;
		this.content = content;
		this.name=name;
	}

	public Response(long id, String content) {
		this.id = id;
		this.content = content;
		this.name="name";
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getName() {
		return name;
	}

	public List<String> getNotes() {
		return notes;
	}
}