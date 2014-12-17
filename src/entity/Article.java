package entity;

import java.util.ArrayList;

public class Article {
	String seq;
	String usrSeq;
	String usrName;
	String title;
	String contents;
	String createDate;
	String updateDate;
	ArrayList<Comment> CommentList;

	public Article(String seq, String title, String createDate) {
		this(seq, null, null, title, null, createDate, null, null);
	}

	public Article(String usrName, String title, String contents,
			String createDate, String updateDate) {
		this(null, null, usrName, title, contents, createDate, updateDate, null);
	}

	public Article(String seq, String usrSeq, String usrName, String title,
			String contents, String createDate, String updateDate) {
		this(seq, usrSeq, usrName, title, contents, createDate, updateDate, null);
	}
	
	public Article(String seq, String usrSeq, String usrName, String title,
			String contents, String createDate, String updateDate,
			ArrayList<Comment> commentList) {
		super();
		this.seq = seq;
		this.usrSeq = usrSeq;
		this.usrName = usrName;
		this.title = title;
		this.contents = contents;
		this.createDate = createDate;
		this.updateDate = updateDate;
		CommentList = commentList;
	}
	
	public String getSeq() {
		return seq;
	}
	public String getUsrSeq() {
		return usrSeq;
	}
	public String getUsrName() {
		return usrName;
	}
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	public String getCreateDate() {
		return createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public ArrayList<Comment> getCommentList() {
		return CommentList;
	}
}
