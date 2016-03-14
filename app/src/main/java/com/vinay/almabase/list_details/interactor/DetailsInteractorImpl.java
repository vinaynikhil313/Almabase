package com.vinay.almabase.list_details.interactor;

import android.util.Log;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinay.almabase.comment.Comment;
import com.vinay.almabase.list_details.presenter.OnDetailsGeneratedListener;
import com.vinay.almabase.post.Post;
import com.vinay.almabase.user.User;
import com.vinay.almabase.utils.Constants;
import com.vinay.almabase.utils.RestApiClient;
import com.vinay.almabase.utils.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Vinay Nikhil Pabba on 14-03-2016.
 */
public class DetailsInteractorImpl implements DetailsInteractor {

	private final String TAG = Utilities.getTag(this);

	private OnDetailsGeneratedListener listener;

	private int mType;

	@Override
	public void fetchDetails(int type, OnDetailsGeneratedListener listener) {
		this.listener = listener;
		mType = type;
		Log.i(TAG, Constants.ITEMS[type]);
		RestApiClient.get(Constants.ITEMS[type], null, new JsonHttpResponseHandler());
	}

	private class JsonHttpResponseHandler extends com.loopj.android.http.JsonHttpResponseHandler{

		@Override
		public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
			try {
				//Log.i(TAG, response.toString(5));
				ObjectMapper objectMapper = new ObjectMapper();

				List<Object> mObjects = new ArrayList<>();

				switch(mType){
					//posts
					case 0:
						List<Object> mPosts = new ArrayList<>();
						for(int i=0;i<response.length();i++){
							mObjects.add(objectMapper.readValue(response.getJSONObject(i).toString(), Post.class));
						}
						break;
					//comments
					case 1:
						for(int i=0;i<response.length();i++){
							mObjects.add(objectMapper.readValue(response.getJSONObject(i).toString(), Comment.class));
						}
						break;
					//users
					case 2:
						List<User> mUsers = new ArrayList<>();
						for(int i=0;i<response.length();i++){
							mObjects.add(objectMapper.readValue(response.getJSONObject(i).toString(), User.class));
						}
						break;

				}

				listener.onListGenerated(mObjects);


			} catch(JSONException e) {
				e.printStackTrace();
			} catch(JsonMappingException e) {
				e.printStackTrace();
			} catch(JsonParseException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
			Log.e(TAG, "Error in fetching JSON");
		}
	}

}
