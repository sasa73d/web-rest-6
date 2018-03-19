package com.izba.post;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PostDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<Post> listPosts(long id, long userId) {
		String hql = "from Post p";
		if (id > 0 && userId <= 0) {
			hql = hql + " where p.id = " + id;
		} else if (id <= 0 && userId > 0) {
			hql = hql + " where p.userId = " + userId;
		} else if (id > 0 && userId > 0) {
			hql = hql + " where p.id = " + id + " or p.userId = " + userId;
		}
		Session session = this.sessionFactory.getCurrentSession();
		List<Post> posts = session.createQuery(hql).list();
		return posts;
	}

	public Post getPost(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Post post = (Post) session.get(Post.class, id);
		return post;
	}

	public Post addPost(Post post) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(post);
		return post;
	}

	public void updatePost(Post post) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(post);
	}

	public void deletePost(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Post post = (Post) session.get(Post.class, id);
		if (null != post) {
			session.delete(post);
		}
	}	
}
