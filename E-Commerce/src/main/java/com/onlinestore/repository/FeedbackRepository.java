package com.onlinestore.repository;

import org.springframework.data.repository.CrudRepository;

import com.onlinestore.domain.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback,Long>  {

}
