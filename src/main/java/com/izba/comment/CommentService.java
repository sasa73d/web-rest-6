package com.izba.comment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commentService")
public class CommentService {

	@Autowired
	CommentDao commentDao;
	
	@Transactional
	public List<Comment> getComments(long id, long postId) {
		return commentDao.listComments(id, postId);
	}

	@Transactional
	public Comment getComment(long id) {
		return commentDao.getComment(id);
	}

	@Transactional
	public Comment addComment(Comment comment) {
		return commentDao.addComment(comment);
	}

	@Transactional
	public void updateComment(Comment comment) {
		commentDao.updateComment(comment);
	}

	@Transactional
	public void deleteComment(long id) {
		commentDao.deleteComment(id);
	}
}
