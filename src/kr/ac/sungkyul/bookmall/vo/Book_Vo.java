package kr.ac.sungkyul.bookmall.vo;

public class Book_Vo {
	private Long no;
	private String title;
	private Integer rate;
	private Long authorNo;
	private String state_code;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Long getAuthorNo() {
		return authorNo;
	}

	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	@Override
	public String toString() {
		return "Book_Vo [no=" + no + ", title=" + title + ", rate=" + rate + ", authorNo=" + authorNo + ", state_code="
				+ state_code + "]";
	}

	
	
}
