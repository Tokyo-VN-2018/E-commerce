package com.onlinestore.service;

import java.util.List;

import com.onlinestore.domain.Feedback;

public interface FeedbackService {
	Feedback save(Feedback feedback);
	List<Feedback> selectAll();
}
