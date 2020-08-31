package com.example.quest;

public class Response {

	private final long id;
	private final String content;
	private final String name;

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
}