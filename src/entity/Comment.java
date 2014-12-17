package entity;

public class Comment {
	String seq;
	String articleSeq;
	String name;
	String contents;
	String createDate;
	String updateDate;
	
	public Comment(String name, String contents, String createDate,
			String updateDate) {
		super();
		this.name = name;
		this.contents = contents;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public String getSeq() {
		return seq;
	}
	public String getArticleSeq() {
		return articleSeq;
	}
	public String getName() {
		return name;
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

	
}
