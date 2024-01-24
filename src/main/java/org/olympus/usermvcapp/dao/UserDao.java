package org.olympus.usermvcapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.olympus.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private Session session;
	
	
	public User save(User user) {
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		return user;
	}
	
	@Transactional
	public User update(User user) {
		Transaction transaction = session.beginTransaction();
		session.clear();
		session.update(user);
		transaction.commit();
		return user;
	}
	
	public List<User> findAll(){
		String query = "select u from User u";
		Query<User> q = session.createQuery(query);
		List<User> users = q.getResultList();
		if(users.size()>0) {
			return users;
		}
		return null;
	}
	
	public User find(int id) {
		User u = session.get(User.class, id);
		if(u!=null) {
			return u;
		}
		return null;
	}
	
	public boolean delete(int id) {
		User u = find(id);
		if(u!=null) {
			Transaction transaction = session.beginTransaction();
			session.delete(u);
			transaction.commit();
			return true;
			}
		else
			return false;
	}
	
	

}
