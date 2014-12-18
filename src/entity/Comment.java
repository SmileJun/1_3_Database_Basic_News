package entity;

public class Comment {
	String seq;
	String articleSeq;
	String usrSeq;
	String usrName;
	String contents;
	String createDate;
	String updateDate;

	public Comment(String usrName, String contents, String createDate,
			String updateDate) {
		super();
		this.usrName = usrName;
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
	public String getUsrSeq() {
		return usrSeq;
	}
	public String getUsrName() {
		return usrName;
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

	@Override
	public String toString() {
		return "Comment [seq=" + seq + ", articleSeq=" + articleSeq
				+ ", usrSeq=" + usrSeq + ", usrName=" + usrName + ", contents="
				+ contents + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
}
