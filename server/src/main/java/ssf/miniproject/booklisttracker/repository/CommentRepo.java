package ssf.miniproject.booklisttracker.repository;

import java.util.LinkedList;
import java.util.List;
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

	public List<Comment> getComments(String bookId) {
        System.out.println("finding comments");
		
        List<Document> results = template.find(Query.query(Criteria.where("bookId").is(bookId)), 
        Document.class, "comments");
		
        List<Comment> commentsList = new LinkedList<>();
        
        for(Document d: results){
            Comment c = Comment.create(d);
            commentsList.add(c);
        }

		return commentsList;
	}

    
}
