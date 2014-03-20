package databeans;

public class CommentCountBean {
	private String username;
	private int count;
	private String category;
	
	public String getUsername() {
		return username;
	}
	public int getCount() {
		return count;
	}
	public String getCategory() {
		return category;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
