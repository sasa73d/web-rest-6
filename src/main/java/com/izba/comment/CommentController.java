package com.izba.comment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/comments", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Comment> getComments(@RequestParam(value="id", defaultValue = "0", required = false) long id,
								@RequestParam(value="postId", defaultValue = "0", required = false) long postId) {
		
		List<Comment> comments = commentService.getComments(id, postId);
		return comments;
	}

	@RequestMapping(value = "/comments/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Comment getCommentById(@PathVariable long id) {
		return commentService.getComment(id);
	}

	@RequestMapping(value = "/comments", method = RequestMethod.POST, headers = "Accept=application/json")
	public Comment addComment(@RequestBody Comment comment) {	
		return commentService.addComment(comment);
	}

	@RequestMapping(value = "/comments", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Comment updateComment(@RequestBody Comment comment) {
		commentService.updateComment(comment);
		return comment;
	}

	@RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteComment(@PathVariable("id") long id) {
		commentService.deleteComment(id);		
	}	
}
