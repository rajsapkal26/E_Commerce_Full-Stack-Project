package com.org.model;

public class PaymentDetails {
	
	private String paymentMethod;
	private String status;
	private String PaymentId;
	private String razorpayPaymentLinkId;
	private String razorpayPaymentLinkReferanceId;
	private String razorpayPaymentLinkStatus;
	private String razorpayPaymentId;
	
	public PaymentDetails() {
		// TODO Auto-generated constructor stub
	}

	public PaymentDetails(String paymentMethod, String status, String paymentId, String razorpayPaymentLinkId,
			String razorpayPaymentLinkReferanceId, String razorpayPaymentLinkStatus, String razorpayPaymentId) {
		super();
		this.paymentMethod = paymentMethod;
		this.status = status;
		PaymentId = paymentId;
		this.razorpayPaymentLinkId = razorpayPaymentLinkId;
		this.razorpayPaymentLinkReferanceId = razorpayPaymentLinkReferanceId;
		this.razorpayPaymentLinkStatus = razorpayPaymentLinkStatus;
		this.razorpayPaymentId = razorpayPaymentId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentId() {
		return PaymentId;
	}

	public void setPaymentId(String paymentId) {
		PaymentId = paymentId;
	}

	public String getRazorpayPaymentLinkId() {
		return razorpayPaymentLinkId;
	}

	public void setRazorpayPaymentLinkId(String razorpayPaymentLinkId) {
		this.razorpayPaymentLinkId = razorpayPaymentLinkId;
	}

	public String getRazorpayPaymentLinkReferanceId() {
		return razorpayPaymentLinkReferanceId;
	}

	public void setRazorpayPaymentLinkReferanceId(String razorpayPaymentLinkReferanceId) {
		this.razorpayPaymentLinkReferanceId = razorpayPaymentLinkReferanceId;
	}

	public String getRazorpayPaymentLinkStatus() {
		return razorpayPaymentLinkStatus;
	}

	public void setRazorpayPaymentLinkStatus(String razorpayPaymentLinkStatus) {
		this.razorpayPaymentLinkStatus = razorpayPaymentLinkStatus;
	}

	public String getRazorpayPaymentId() {
		return razorpayPaymentId;
	}

	public void setRazorpayPaymentId(String razorpayPaymentId) {
		this.razorpayPaymentId = razorpayPaymentId;
	}
	
	

}
