package com.izba.photo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PhotoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<Photo> listPhotos(long id, long albumId) {
		String hql = "from Photo p";
		if (id > 0 && albumId <= 0) {
			hql = hql + " where p.id = " + id;
		} else if (id <= 0 && albumId > 0) {
			hql = hql + " where p.albumId = " + albumId;
		} else if (id > 0 && albumId > 0) {
			hql = hql + " where p.id = " + id + " or p.albumtId = " + albumId;
		}
		Session session = this.sessionFactory.getCurrentSession();
		List<Photo> photos = session.createQuery(hql).list();
		return photos;
	}

	public Photo getPhoto(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Photo photo = (Photo) session.get(Photo.class, id);
		return photo;
	}

	public Photo addPhoto(Photo photo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(photo);
		return photo;
	}

	public void updatePhoto(Photo photo) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(photo);
	}

	public void deletePhoto(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Photo photo = (Photo) session.get(Photo.class, id);
		if (null != photo) {
			session.delete(photo);
		}
	}	
}
