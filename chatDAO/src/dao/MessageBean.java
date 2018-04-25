package dao;

public class MessageBean {
	private String content;
	private UserBean author;

	public MessageBean() {
		this("test");
	}

	public MessageBean(String content) {

		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserBean getAuthor() {
		return author;
	}

	public void setAuthor(UserBean author) {
		this.author = author;
	}

}
