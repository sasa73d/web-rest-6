package com.izba.post;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Post> getPosts(@RequestParam(value="id", defaultValue = "0", required = false) long id,
								@RequestParam(value="userId", defaultValue = "0", required = false) long userId) {
		
		List<Post> posts = postService.getPosts(id, userId);
		return posts;
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Post getPostById(@PathVariable long id) {
		return postService.getPost(id);
	}

	@RequestMapping(value = "/posts", method = RequestMethod.POST, headers = "Accept=application/json")
	public Post addPost(@RequestBody Post post) {	
		return postService.addPost(post);
	}

	@RequestMapping(value = "/posts", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Post updatePost(@RequestBody Post post) {
		postService.updatePost(post);
		return post;
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deletePost(@PathVariable("id") long id) {
		postService.deletePost(id);		
	}	
}
