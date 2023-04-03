package com.tushar.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tushar.dao.UserDao;
import com.tushar.models.Users;

@Service
@Transactional
public class UsersServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public int getUserFromDB(Users user) {
		// TODO Auto-generated method stub
		
		return dao.getUserFromDB(user);
	}

	@Override
	public Users getUserByUserID(int userid) {
		// TODO Auto-generated method stub
		return dao.getUserByUserID(userid);
	}
}
