package com.org.request;

public class ReviewRequest {

	private Long productid;
	private String review;
	
	public ReviewRequest() {
		// TODO Auto-generated constructor stub
	}

	public ReviewRequest(Long productid, String review) {
		super();
		this.productid = productid;
		this.review = review;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	
	
}
