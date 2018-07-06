// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.restclienttemplate;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TweetDetailActivity_ViewBinding<T extends TweetDetailActivity> implements Unbinder {
  protected T target;

  @UiThread
  public TweetDetailActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.ivProfilePic = Utils.findRequiredViewAsType(source, R.id.ivPosterProfile, "field 'ivProfilePic'", ImageView.class);
    target.userName = Utils.findRequiredViewAsType(source, R.id.tvUserName, "field 'userName'", TextView.class);
    target.body = Utils.findRequiredViewAsType(source, R.id.tvBody, "field 'body'", TextView.class);
    target.replyButton = Utils.findRequiredViewAsType(source, R.id.btReply, "field 'replyButton'", Button.class);
    target.screenName = Utils.findRequiredViewAsType(source, R.id.tvScreenName, "field 'screenName'", TextView.class);
    target.etReply = Utils.findRequiredViewAsType(source, R.id.etReply, "field 'etReply'", EditText.class);
    target.tvNumLikes = Utils.findRequiredViewAsType(source, R.id.tvNumLikes, "field 'tvNumLikes'", TextView.class);
    target.tvNumRetweet = Utils.findRequiredViewAsType(source, R.id.tvNumRetweet, "field 'tvNumRetweet'", TextView.class);
    target.tvNumFollowers = Utils.findRequiredViewAsType(source, R.id.tvNumFollowers, "field 'tvNumFollowers'", TextView.class);
    target.tvNumTweets = Utils.findRequiredViewAsType(source, R.id.tvNumTweets, "field 'tvNumTweets'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivProfilePic = null;
    target.userName = null;
    target.body = null;
    target.replyButton = null;
    target.screenName = null;
    target.etReply = null;
    target.tvNumLikes = null;
    target.tvNumRetweet = null;
    target.tvNumFollowers = null;
    target.tvNumTweets = null;

    this.target = null;
  }
}
