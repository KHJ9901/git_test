package com.plant.dto;

public class Diary {
	private String diary_seqno;
	private String id;
	private String name;
	private String wdate;
	private String content;
	
	public String getDiary_seqno() {
		return diary_seqno;
	}
	public void setDiary_seqno(String diary_seqno) {
		this.diary_seqno = diary_seqno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	

}
