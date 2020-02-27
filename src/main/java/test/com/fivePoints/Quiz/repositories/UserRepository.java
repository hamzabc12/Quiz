package test.com.fivePoints.Quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import test.com.fivePoints.Quiz.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
