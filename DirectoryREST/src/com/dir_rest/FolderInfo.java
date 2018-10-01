package com.dir_rest;

public class FolderInfo {
	
	private final long id;
	private final String content;
	
	public FolderInfo (long id, String content)	{
		this.id = id;
		this.content = content;
	}
	
	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}

}
