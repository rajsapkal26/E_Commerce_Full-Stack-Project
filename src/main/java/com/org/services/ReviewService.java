package com.org.services;

import java.util.List;

import com.org.exceptions.ProductException;
import com.org.model.Review;
import com.org.model.User;
import com.org.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req, User user) throws ProductException;
	
	public List<Review> getAllReviews(Long productId);
}
