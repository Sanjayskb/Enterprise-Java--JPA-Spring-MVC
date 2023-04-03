package com.tushar.service;

import com.tushar.models.Users;

public interface UserService {

	int getUserFromDB(Users user);

	Users getUserByUserID(int userid);

}
