package com.tushar.dao;

import com.tushar.models.Users;

public interface UserDao {

	int getUserFromDB(Users user);

	Users getUserByUserID(int userid);

}
