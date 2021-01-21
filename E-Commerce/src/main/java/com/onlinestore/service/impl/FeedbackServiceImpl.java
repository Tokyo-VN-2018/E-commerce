package com.onlinestore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinestore.domain.Feedback;
import com.onlinestore.repository.FeedbackRepository;
import com.onlinestore.service.FeedbackService;


@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;
	
	public Feedback save(Feedback feedback) {
		return (Feedback)feedbackRepository.save(feedback);
	}
	
	public List<Feedback> selectAll(){
		return (List<Feedback>) feedbackRepository.findAll();
	};
}
