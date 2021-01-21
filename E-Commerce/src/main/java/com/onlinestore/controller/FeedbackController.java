package com.onlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinestore.domain.Feedback;
import com.onlinestore.service.FeedbackService;

@Controller
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	
	@RequestMapping("/feedback")
	public String feedback(@ModelAttribute("feedback") Feedback feedback, Model model) {
		feedback = feedbackService.save(feedback);
		model.addAttribute("feedbacked", true);
		return "contact";
	}
	
	@RequestMapping("/feedbackList")
	public String fbList(Model model) {
		model.addAttribute("feedbacks", feedbackService.selectAll());
		return "feedbackList";
	}
}
