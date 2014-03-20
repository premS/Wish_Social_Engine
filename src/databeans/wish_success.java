package databeans;

public class wish_success {
	private String category;
	private String uname;
	private int count;
	public void setCategory(String userId) {
		this.category = userId;
	}
	public void setCount(int userId) {
		this.count = userId;
	}
	public void setUname(String userId) {
		this.uname = userId;
	}
	public String getCategory() {
		return this.category;
	}
	public int getCount() {
		return this.count;
	}
	public String getUname() {
		return this.uname;
	}
}
