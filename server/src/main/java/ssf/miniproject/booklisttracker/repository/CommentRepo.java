package ssf.miniproject.booklisttracker.repository;

import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Repository;

import ssf.miniproject.booklisttracker.model.Comment;

@Repository
public class CommentRepo {

    @Autowired
	private MongoTemplate template;

	public ObjectId insertPost(Comment comment) {
		Document insertedDoc = template.insert(comment.toDocument(), "comments");
		return insertedDoc.getObjectId("_id");
	}

	public Optional<Comment> getComments(String bookId) {
		Criteria criteria = Criteria.where("bookId").is(bookId);
		Query query = Query.query(criteria);
		Document result = template.findOne(query, Document.class, "comments");
		if (null == result)
			return Optional.empty();

		return Optional.of(Comment.create(result));
	}

    
}
