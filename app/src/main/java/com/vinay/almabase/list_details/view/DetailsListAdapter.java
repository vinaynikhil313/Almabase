package com.vinay.almabase.list_details.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vinay.almabase.R;
import com.vinay.almabase.comment.Comment;
import com.vinay.almabase.post.Post;
import com.vinay.almabase.user.User;

import java.util.List;

/**
 * Created by Vinay Nikhil Pabba on 15-03-2016.
 */
public class DetailsListAdapter extends ArrayAdapter<Object> {

	private List<Object> objects;

	public DetailsListAdapter(Context context, List<Object> objects) {
		super(context, 0);
		this.objects = objects;
	}

	@Override
	public int getCount() {
		return objects.size();
	}

	@Override
	public Object getItem(int position) {
		return objects.get(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/*if(convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.post_item, parent, false);
		}
		Post post = (Post) getItem(position);

		TextView title = (TextView) convertView.findViewById(R.id.post_title);
		TextView userId = (TextView) convertView.findViewById(R.id.post_userid);
		TextView id = (TextView) convertView.findViewById(R.id.post_id);
		TextView body = (TextView) convertView.findViewById(R.id.post_body);

		title.setText(post.getTitle());
		userId.setText("User ID :" + post.getUserId());
		id.setText("ID : " + post.getId());
		body.setText(post.getBody());

		return convertView;*/

		if(getItem(position) instanceof Post)
			return setupPost(position, parent);
		else if (getItem(position) instanceof Comment)
			return setupComment(position, parent);
		else
			return setupUser(position, parent);

	}

	private View setupPost(int position, ViewGroup parent){
		View view = LayoutInflater.from(getContext()).inflate(R.layout.post_item, parent, false);

		Post post = (Post) getItem(position);

		TextView title = (TextView) view.findViewById(R.id.post_title);
		TextView userId = (TextView) view.findViewById(R.id.post_userid);
		TextView id = (TextView) view.findViewById(R.id.post_id);
		TextView body = (TextView) view.findViewById(R.id.post_body);

		title.setText(post.getTitle());
		userId.setText("User ID :" + post.getUserId());
		id.setText("ID : " + post.getId());
		body.setText(post.getBody());

		return view;
	}

	private View setupComment(int position, ViewGroup parent){
		View view = LayoutInflater.from(getContext()).inflate(R.layout.comment_item, parent, false);

		Comment comment = (Comment) getItem(position);

		TextView name = (TextView) view.findViewById(R.id.comment_name);
		TextView postId = (TextView) view.findViewById(R.id.comment_postid);
		TextView id = (TextView) view.findViewById(R.id.comment_id);
		TextView email = (TextView) view.findViewById(R.id.comment_email);
		TextView body = (TextView) view.findViewById(R.id.comment_body);

		name.setText(comment.getName());
		postId.setText("User ID :" + comment.getPostId());
		id.setText("ID : " + comment.getId());
		email.setText("Email : " + comment.getEmail());
		body.setText(comment.getBody());

		return view;
	}

	private View setupUser(int position, ViewGroup parent){
		View view = LayoutInflater.from(getContext()).inflate(R.layout.user_item, parent, false);

		User user = (User) getItem(position);

		TextView name = (TextView) view.findViewById(R.id.user_name);
		TextView username = (TextView) view.findViewById(R.id.user_username);
		TextView id = (TextView) view.findViewById(R.id.user_id);
		TextView email = (TextView) view.findViewById(R.id.user_email);
		TextView address = (TextView) view.findViewById(R.id.user_address);
		TextView phone = (TextView) view.findViewById(R.id.user_phone);

		name.setText(user.getName());
		username.setText(user.getUsername());
		id.setText("ID : " + user.getId());
		email.setText("Email : " + user.getEmail());
		phone.setText("Phone No : " + user.getPhone());
		address.setText(user.getAddress().get("street") + ", "
		+ user.getAddress().get("suite") + ", "
				+ user.getAddress().get("city") + " - "
				+ user.getAddress().get("zipcode"));

		return view;
	}

}
