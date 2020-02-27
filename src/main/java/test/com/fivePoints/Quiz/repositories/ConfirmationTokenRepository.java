package test.com.fivePoints.Quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import test.com.fivePoints.Quiz.entities.ConfirmationToken;
import test.com.fivePoints.Quiz.entities.User;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
	ConfirmationToken findByUser(User user);
}
