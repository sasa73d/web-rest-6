package com.izba.photo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PhotoController {
	
	@Autowired
	PhotoService photoService;
	
	@RequestMapping(value = "/photos", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Photo> getPhotos(@RequestParam(value="id", defaultValue = "0", required = false) long id,
								@RequestParam(value="albumId", defaultValue = "0", required = false) long albumId) {
		
		List<Photo> photos = photoService.getPhotos(id, albumId);
		return photos;
	}

	@RequestMapping(value = "/photos/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Photo getPhotoById(@PathVariable long id) {
		return photoService.getPhoto(id);
	}

	@RequestMapping(value = "/photos", method = RequestMethod.POST, headers = "Accept=application/json")
	public Photo addPhoto(@RequestBody Photo photo) {	
		return photoService.addPhoto(photo);
	}

	@RequestMapping(value = "/photos", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Photo updatePhoto(@RequestBody Photo photo) {
		photoService.updatePhoto(photo);
		return photo;
	}

	@RequestMapping(value = "/photos/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deletePhoto(@PathVariable("id") long id) {
		photoService.deletePhoto(id);		
	}	
}
