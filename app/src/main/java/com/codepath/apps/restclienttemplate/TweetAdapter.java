package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*This is the recycler adapter and helps bind the viewholders to the recyclerview*/

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{

    private List <Tweet> mTweets;
    Context context;

    //pass in the tweets in the constructor
    public TweetAdapter(List <Tweet> tweets){
        mTweets = tweets;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View tweetView = inflater.inflate(R.layout.item_tweet, parent,false);
        ViewHolder viewHolder = new ViewHolder(tweetView);
        return  viewHolder;
    }


    //bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get data according to position
        Tweet tweet = mTweets.get(position);
        //populate views accrding to data
        holder.tvUsername.setText(tweet.user.name);
        holder.tvBody.setText(tweet.body);
        holder.tvTime.setText(tweet.time);
        holder.tvNumRetweet.setText(Integer.toString(tweet.retweetCount));
        holder.tvNumLikes.setText(Integer.toString(tweet.favouriteCount));
        holder.tvScreenName.setText("@"+tweet.user.screenName);
        //load image using glideapp
        Glide.with(context).load(tweet.user.profileImageUrl).into(holder.ivProfileImage);
    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }
    // Clean all elements of the recycler
    public void clear() {
        mTweets.clear();
        notifyDataSetChanged();
    }
    // Add a list of tweets to mTweets
    public void addAll(List<Tweet> list) {
        mTweets.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        @BindView(R.id.ivProfileImage) ImageView ivProfileImage;
        @BindView(R.id.tvUserName) TextView tvUsername;
        @BindView(R.id.tvTime) TextView tvTime;
        @BindView(R.id.tvBody) TextView tvBody;
        @BindView(R.id.tvNumLikes) TextView tvNumLikes;
        @BindView(R.id.tvNumRetweet) TextView tvNumRetweet;
        @BindView(R.id.tvScreenName) TextView tvScreenName;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // gets item position
            int position = getAdapterPosition();
            // make sure the position is valid, i.e. actually exists in the view
            if (position != RecyclerView.NO_POSITION) {
                // get the movie at the position, this won't work if the class is static
                Tweet tweet = mTweets.get(position);
                // create intent for the new activity
                Intent intent = new Intent(context, TweetDetailActivity.class);
                // serialize the movie using parceler, use its short name as a key
                intent.putExtra(Tweet.class.getSimpleName(), Parcels.wrap(tweet));
                // show the activity
                context.startActivity(intent);
            }
        }
    }
}
