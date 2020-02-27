package test.com.fivePoints.Quiz.services;

import test.com.fivePoints.Quiz.entities.User;

public interface IServiceUser {
	public void register(User u);
	public User findById(int id);
    public User findByEmail(String email);

}
