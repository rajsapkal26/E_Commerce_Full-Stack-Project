package com.org.services;

import java.util.List;

import com.org.exceptions.ProductException;
import com.org.model.Rating;
import com.org.model.User;
import com.org.request.RatingRequest;

public interface RatingService {

	public Rating crateRating(RatingRequest req, User user) throws ProductException;
	
	public List<Rating> getProductsRating(Long productId);
	
}
