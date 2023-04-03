package com.tushar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.tushar.models.Users;

@Service
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public int getUserFromDB(Users user) {
		// TODO Auto-generated method stub
		Query q=em.createNativeQuery("select * from user where email='"+user.getEmail()+"' and password='"+user.getPassword()+"'", Users.class);
		
		List<Users> list=q.getResultList();
		if(list.isEmpty()) {
			return 0;
		}else
		{
			return list.get(0).getUser_id();
		}
		
	}

	@Override
	public Users getUserByUserID(int userid) {
		Users u=em.find(Users.class,userid);
		return u;
	}

}
