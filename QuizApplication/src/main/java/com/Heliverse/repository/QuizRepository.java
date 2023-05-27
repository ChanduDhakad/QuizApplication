package com.Heliverse.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Heliverse.model.Quiz;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
	Optional<Quiz> findByStartDateBeforeAndEndDateAfter(LocalDateTime startDate, LocalDateTime endDate);
}