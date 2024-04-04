package com.org.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.org.exceptions.ProductException;
import com.org.model.Product;
import com.org.model.Rating;
import com.org.model.User;
import com.org.repository.RatingRepository;
import com.org.request.RatingRequest;

@Service
public class RatingServiceImp implements RatingService {

	private RatingRepository ratingRepo;
	private ProductService productService;
	
	
	public RatingServiceImp(RatingRepository ratingRepo, ProductService productService) {

		this.ratingRepo  = ratingRepo;
		this.productService = productService;
	}
	
	
	@Override
	public Rating crateRating(RatingRequest req, User user) throws ProductException {

		Product product = productService.findProductById(req.getProductId());
		
		Rating rating = new Rating();
		
		rating.setProduct(product);
		rating.setUser(user);
		rating.setRating(req.getRating());
		rating.setCreatedAt(LocalDateTime.now());
		
		
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getProductsRating(Long productId) {

		return ratingRepo.getAllProductsRating(productId);
	}

}
