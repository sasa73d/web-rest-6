package com.izba.album;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AlbumController {
	
	@Autowired
	AlbumService albumService;
	
	@RequestMapping(value = "/albums", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Album> getAlbums(@RequestParam(value="id", defaultValue = "0", required = false) long id,
								@RequestParam(value="userId", defaultValue = "0", required = false) long userId) {
		
		List<Album> albums = albumService.getAlbums(id, userId);
		return albums;
	}

	@RequestMapping(value = "/albums/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Album getAlbumById(@PathVariable long id) {
		return albumService.getAlbum(id);
	}

	@RequestMapping(value = "/albums", method = RequestMethod.POST, headers = "Accept=application/json")
	public Album addAlbum(@RequestBody Album album) {	
		return albumService.addAlbum(album);
	}

	@RequestMapping(value = "/albums", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Album updateAlbum(@RequestBody Album album) {
		albumService.updateAlbum(album);
		return album;
	}

	@RequestMapping(value = "/albums/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteAlbum(@PathVariable("id") long id) {
		albumService.deleteAlbum(id);		
	}	
}
