package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;
import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

/**
 * This activity renders more details about the tweet.
 * It also enables you to like a tweet and retweet.
 * You can also reply to a tweet
 * **/


public class TweetDetailActivity extends AppCompatActivity {
    Tweet tweet;
    Context context;
    TwitterClient client;
    //views
    //track view objects
    @BindView(R.id.ivPosterProfile)  ImageView ivProfilePic;
    @BindView(R.id.tvUserName) TextView userName;
    @BindView(R.id.tvBody) TextView body;
    @BindView(R.id.btReply) Button replyButton;
    @BindView(R.id.tvScreenName) TextView screenName;
    @BindView(R.id.etReply) EditText etReply;
    @BindView(R.id.tvNumLikes) TextView tvNumLikes;
    @BindView(R.id.tvNumRetweet) TextView tvNumRetweet;
    @BindView(R.id.tvNumFollowers) TextView tvNumFollowers;
    @BindView(R.id.tvNumTweets) TextView tvNumTweets;
    @BindView(R.id.ivNumLikes) ImageView ivNumLikes;
    @BindView(R.id.ivNumRetweet) ImageView ivNumRetweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_detail);
        ButterKnife.bind(this);
        client = TwitterApp.getRestClient(this);
        context = getApplicationContext();
        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));
        //get the views

        //set up text
        userName.setText(tweet.user.name);
        screenName.setText("@"+tweet.user.screenName);
        body.setText(tweet.body);
        tvNumLikes.setText(Integer.toString(tweet.favouriteCount));
        tvNumRetweet.setText(Integer.toString(tweet.retweetCount));
        tvNumFollowers.setText(tweet.user.followersCount);
        tvNumTweets.setText(tweet.user.tweetCount);
        //if tweet is favorited, then change the tintcolor
        if (tweet.favorited) ivNumLikes.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        //if tweet is retweeted, change the tint color
        if(tweet.retweeted) ivNumRetweet.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        //set up image
        setUpImage(tweet.user.profileImageUrl);


    }
    private void setUpImage(String imageUrl){
        Glide.with(context)
                .load(imageUrl)
                .into(ivProfilePic);
    }
    public  void onClickReply(View view){
        etReply = (EditText) findViewById(R.id.etReply);
        String reply = etReply.getText().toString();
        String id = Long.toString( tweet.uid);
        client.replyToTweet(reply,id,new JsonHttpResponseHandler(){
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                Log.d("TwitterClient",errorResponse.toString());
                throwable.printStackTrace();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("TwitterClient",responseString);
                throwable.printStackTrace();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.d("TwitterClient",response.toString());
                Log.d("Inside resp",response.toString());

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("TwitterClient",responseString);
                Log.d("Inside resp string",responseString);
                Toast.makeText(context,"Replied!", Toast.LENGTH_SHORT);

            }

            //method that returns to the timeline activity
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast.makeText(context,"Replied!", Toast.LENGTH_SHORT).show();
                etReply.setText("");

            }
        });



    }


    public void onClickFav(View view){
        client.favoriteTweet(Long.toString(tweet.uid),new JsonHttpResponseHandler(){
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                Log.d("TwitterClient",errorResponse.toString());
                throwable.printStackTrace();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("TwitterClient",responseString);
                throwable.printStackTrace();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.d("TwitterClient",response.toString());
                Log.d("Inside resp",response.toString());

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("TwitterClient",responseString);
                Log.d("Inside resp string",responseString);
                Toast.makeText(context,"First success!", Toast.LENGTH_SHORT).show();

            }

            //method that returns to the timeline activity
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //update the color and the number of likes
                ivNumLikes.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                tvNumLikes.setText(Integer.toString(tweet.favouriteCount + 1));
            }
        });


    }


    public void onClickRetweet(View view){

        client.reTweet(Long.toString(tweet.uid),new JsonHttpResponseHandler(){
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                Log.d("TwitterClient",errorResponse.toString());
                throwable.printStackTrace();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("TwitterClient",responseString);
                throwable.printStackTrace();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.d("TwitterClient",response.toString());
                Log.d("Inside resp",response.toString());

            }


            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.d("TwitterClient",responseString);
                Log.d("Inside resp string",responseString);
                Toast.makeText(context,"First success!", Toast.LENGTH_SHORT).show();

            }

            //method that returns to the timeline activity
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //update the color and the number of likes
                ivNumRetweet.setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
                tvNumRetweet.setText(Integer.toString(tweet.retweetCount + 1));
            }
        });


    }

}
