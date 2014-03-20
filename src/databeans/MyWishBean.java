//Sophia
package databeans;

import java.sql.Date;

import org.genericdao.PrimaryKey;

@PrimaryKey("mwid")
public class MyWishBean {
	
	int mwid;
	String category;
	String startdate;
	String state;
	String wishdesc;
	String resultdesc;
	String endDate;
	String imgid;	
	int tag1;
	int tag2;
	int tag3;
	
	public int getMwid() {
		return mwid;
	}
	public void setMwid(int mwid) {
		this.mwid = mwid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getWishdesc() {
		return wishdesc;
	}
	public void setWishdesc(String wishdesc) {
		this.wishdesc = wishdesc;
	}
	public String getResultdesc() {
		return resultdesc;
	}
	public void setResultdesc(String resultdesc) {
		this.resultdesc = resultdesc;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String date) {
		this.endDate = date;
	}
	public String getImgid() {
		return imgid;
	}
	public void setImgid(String imgid) {
		this.imgid = imgid;
	}
	public int getTag1() {
		return tag1;
	}
	public void setTag1(int tag1) {
		this.tag1 = tag1;
	}
	public int getTag2() {
		return tag2;
	}
	public void setTag2(int tag2) {
		this.tag2 = tag2;
	}
	public int getTag3() {
		return tag3;
	}
	public void setTag3(int tag3) {
		this.tag3 = tag3;
	}


}
