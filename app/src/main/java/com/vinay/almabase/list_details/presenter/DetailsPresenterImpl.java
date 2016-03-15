package com.vinay.almabase.list_details.presenter;

import android.util.Log;

import com.vinay.almabase.comment.Comment;
import com.vinay.almabase.list_details.interactor.DetailsInteractor;
import com.vinay.almabase.list_details.interactor.DetailsInteractorImpl;
import com.vinay.almabase.list_details.view.DetailsView;
import com.vinay.almabase.post.Post;
import com.vinay.almabase.user.User;
import com.vinay.almabase.utils.Utilities;

import java.util.List;

/**
 * Created by Vinay Nikhil Pabba on 14-03-2016.
 */
public class DetailsPresenterImpl implements DetailsPresenter, OnDetailsGeneratedListener {

	private DetailsView view;
	private DetailsInteractor interactor;

	private final String TAG = Utilities.getTag(this);

	public DetailsPresenterImpl(DetailsView view) {
		this.view = view;
		this.interactor = new DetailsInteractorImpl();
	}

	@Override
	public void getDetails(int type) {
		interactor.fetchDetails(type, this);
	}

	@Override
	public void onUsersGenerated(List<User> users) {
		Log.i(TAG, "Size = " + users.size());
	}

	@Override
	public void onCommentsGenerated(List<Comment> comments) {
		Log.i(TAG, "Size = " + comments.size());
	}

	@Override
	public void onPostsGenerated(List<Post> posts) {
		Log.i(TAG, "Size = " + posts.size());
	}

	@Override
	public void onListGenerated(List<Object> objects) {
		view.onListGenerated(objects);
		view.hideProgressDialog();
	}
}
