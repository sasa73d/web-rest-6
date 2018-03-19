package com.izba.comment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CommentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<Comment> listComments(long id, long postId) {
		String hql = "from Comment c";
		if (id > 0 && postId <= 0) {
			hql = hql + " where c.id = " + id;
		} else if (id <= 0 && postId > 0) {
			hql = hql + " where c.postId = " + postId;
		} else if (id > 0 && postId > 0) {
			hql = hql + " where c.id = " + id + " or c.postId = " + postId;
		}
		Session session = this.sessionFactory.getCurrentSession();
		List<Comment> comments = session.createQuery(hql).list();
		return comments;
	}

	public Comment getComment(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Comment comment = (Comment) session.get(Comment.class, id);
		return comment;
	}

	public Comment addComment(Comment comment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(comment);
		return comment;
	}

	public void updateComment(Comment comment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(comment);
	}

	public void deleteComment(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Comment comment = (Comment) session.get(Comment.class, id);
		if (null != comment) {
			session.delete(comment);
		}
	}	
}
