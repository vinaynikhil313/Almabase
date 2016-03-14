package com.vinay.almabase.list_details.presenter;

import com.vinay.almabase.comment.Comment;
import com.vinay.almabase.post.Post;
import com.vinay.almabase.user.User;

import java.util.List;

/**
 * Created by Vinay Nikhil Pabba on 14-03-2016.
 */
public interface OnDetailsGeneratedListener {

	void onUsersGenerated(List<User> users);

	void onCommentsGenerated(List<Comment> comments);

	void onPostsGenerated(List<Post> posts);

	void onListGenerated(List<Object> objects);

}
