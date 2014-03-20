package databeans;

public class wish_comment {
private String wish;
private int pid;
private int count;
public void setWish(String userId) {
	this.wish = userId;
}
public void setCount(int userId) {
	this.count = userId;
}
public void setPid(int userId) {
	this.pid = userId;
}
public String getWish() {
	return this.wish;
}
public int getCount() {
	return this.count;
}
public int getPid() {
	return this.pid;
}
}
