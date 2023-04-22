package ssf.miniproject.booklisttracker.service;

import java.util.Optional;
import java.util.UUID;

import org.bson.types.ObjectId;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssf.miniproject.booklisttracker.model.Comment;
import ssf.miniproject.booklisttracker.model.User;
import ssf.miniproject.booklisttracker.repository.CommentRepo;
import ssf.miniproject.booklisttracker.repository.UserRepo;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    public Optional<Comment> getComments(String bookId) {

		// Find the bookId
		Optional<Comment> opt = commentRepo.getComments(bookId);
		if (opt.isEmpty())
			return Optional.empty();

        Comment comment = opt.get();

		return Optional.of(comment);
	}
    
    public Optional<String> createComment(Comment comment) {
        System.out.println("creating in comment service");

		// Check if the user is valid
		Optional<User> opt = userRepo.findUserbyId(comment.getUserId());
		if (opt.isEmpty())
			return Optional.empty();

		// Fill the post with pertinent user details
		User user = opt.get();
		comment.setUsername(user.getUsername());
		comment.setUserId(user.getId());

		// Set the post date
		comment.now();

		// Set a unique post id
		String commentId = UUID.randomUUID().toString().substring(0, 8);
		comment.setCommentId(commentId);


		// Create post in Mongo
		ObjectId objectId = commentRepo.insertPost(comment);

		logger.log(Level.INFO
				, "postId: %s -> _id: %s".formatted(commentId, objectId.toString()));

        System.out.println(comment.getBookId());

		// Setup likes and dislike
		return Optional.of(commentId);
	}
}
