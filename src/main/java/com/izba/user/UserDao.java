package com.izba.user;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUsers(long id) {
		String hql = "from User u";
		if (id > 0) {
			hql = hql + " where u.id = " + id;
		} 	
		Session session = this.sessionFactory.getCurrentSession();
		List<User> users = session.createQuery(hql).list();
		return users;
	}

	public User getUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	public User addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		//session.persist(user);
		session.save(user);
		return user;
	}

	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}

	public void deleteUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		if (null != user) {
			session.delete(user);
		}
	}	
}
