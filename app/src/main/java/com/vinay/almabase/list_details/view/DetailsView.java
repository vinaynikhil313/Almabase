package com.vinay.almabase.list_details.view;

import com.vinay.almabase.comment.Comment;
import com.vinay.almabase.post.Post;
import com.vinay.almabase.user.User;

import java.util.List;

/**
 * Created by Vinay Nikhil Pabba on 14-03-2016.
 */
public interface DetailsView {

	void onUsersListGenerated(List<User> users);

	void onCommentsListGenerated(List<Comment> comments);

	void onPostsListGenerated(List<Post> posts);

	void onListGenerated(List<Object> objects);

}
