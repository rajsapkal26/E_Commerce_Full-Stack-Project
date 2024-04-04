package com.org.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.org.exceptions.ProductException;
import com.org.model.Product;
import com.org.model.Review;
import com.org.model.User;
import com.org.repository.ProductRepository;
import com.org.repository.ReviewRepository;
import com.org.request.ReviewRequest;

@Service
public class ReviewServiceImpl implements ReviewService {

	
	private ReviewRepository reviewRepo;
	private ProductService productService;
	private ProductRepository productRepo;
	
	
	public ReviewServiceImpl(ReviewRepository reviewRepo, ProductService productService, 
								ProductRepository productRepo) {

		this.reviewRepo = reviewRepo;
		this.productService = productService;
		this.productRepo = productRepo;
	
	}
	
	

	
	@Override
	public Review createReview(ReviewRequest req, User user) throws ProductException {

		Product product = productService.findProductById(req.getProductid());
		
		Review review = new Review();
		
		review.setProduct(product);
		review.setUser(user);
		review.setReview(req.getReview());
		review.setCreatedAt(LocalDateTime.now());
		
		
		
		return reviewRepo.save(review);
	}

	@Override
	public List<Review> getAllReviews(Long productId) {
		
		return reviewRepo.getAllProductsReview(productId);
	}

}
