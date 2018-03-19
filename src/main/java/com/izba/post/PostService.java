package com.izba.post;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("postService")
public class PostService {

	@Autowired
	PostDao postDao;
	
	@Transactional
	public List<Post> getPosts(long id, long userId) {
		return postDao.listPosts(id, userId);
	}

	@Transactional
	public Post getPost(long id) {
		return postDao.getPost(id);
	}

	@Transactional
	public Post addPost(Post post) {
		return postDao.addPost(post);
	}

	@Transactional
	public void updatePost(Post post) {
		postDao.updatePost(post);
	}

	@Transactional
	public void deletePost(long id) {
		postDao.deletePost(id);
	}
}
