package com.izba.album;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AlbumDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<Album> listAlbums(long id, long userId) {
		String hql = "from Album a";
		if (id > 0 && userId <= 0) {
			hql = hql + " where a.id = " + id;
		} else if (id <= 0 && userId > 0) {
			hql = hql + " where a.userId = " + userId;
		} else if (id > 0 && userId > 0) {
			hql = hql + " where a.id = " + id + " or a.userId = " + userId;
		}
		System.out.println(hql);
		Session session = this.sessionFactory.getCurrentSession();
		List<Album> albums = session.createQuery(hql).list();
		return albums;
	}

	public Album getAlbum(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Album album = (Album) session.get(Album.class, id);
		return album;
	}

	public Album addAlbum(Album album) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(album);
		return album;
	}

	public void updateAlbum(Album album) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(album);
	}

	public void deleteAlbum(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Album album = (Album) session.get(Album.class, id);
		if (null != album) {
			session.delete(album);
		}
	}	
}
