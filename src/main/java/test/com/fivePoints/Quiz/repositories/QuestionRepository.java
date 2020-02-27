package test.com.fivePoints.Quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import test.com.fivePoints.Quiz.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
