package com.bhaumik.retailstore.bean;

import java.time.LocalDate;

/**
 * @author admin
 * This is User object which help to get user details
 */
public class User {

    private final int userId;
    private final String userName;
    private final UserType userType;
    private final LocalDate userRegistrationDate;

	public User(int userId, String userName, UserType userType, LocalDate userRegistrationDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.userRegistrationDate = userRegistrationDate;
	}

    public LocalDate getUserRegistrationDate() {
        return userRegistrationDate;
    }

    @SuppressWarnings("unused")
    public int getUserId() {
        return userId;
    }

	@SuppressWarnings("unused")
    public String getUserName() {
        return userName;
    }

    public UserType getUserType() {
        return userType;
    }
}
