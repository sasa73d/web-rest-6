package com.izba.album;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("albumService")
public class AlbumService {

	@Autowired
	AlbumDao albumDao;
	
	@Transactional
	public List<Album> getAlbums(long id, long userId) {
		return albumDao.listAlbums(id, userId);
	}

	@Transactional
	public Album getAlbum(long id) {
		return albumDao.getAlbum(id);
	}

	@Transactional
	public Album addAlbum(Album album) {
		return albumDao.addAlbum(album);
	}

	@Transactional
	public void updateAlbum(Album album) {
		albumDao.updateAlbum(album);
	}

	@Transactional
	public void deleteAlbum(long id) {
		albumDao.deleteAlbum(id);
	}
}
