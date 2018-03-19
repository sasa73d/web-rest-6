package com.izba.photo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("photoService")
public class PhotoService {

	@Autowired
	PhotoDao photoDao;
	
	@Transactional
	public List<Photo> getPhotos(long id, long albumId) {
		return photoDao.listPhotos(id, albumId);
	}

	@Transactional
	public Photo getPhoto(long id) {
		return photoDao.getPhoto(id);
	}

	@Transactional
	public Photo addPhoto(Photo photo) {
		return photoDao.addPhoto(photo);
	}

	@Transactional
	public void updatePhoto(Photo photo) {
		photoDao.updatePhoto(photo);
	}

	@Transactional
	public void deletePhoto(long id) {
		photoDao.deletePhoto(id);
	}
}
