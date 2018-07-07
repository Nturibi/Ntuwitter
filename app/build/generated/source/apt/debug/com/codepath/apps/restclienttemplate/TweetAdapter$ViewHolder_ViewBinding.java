// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.restclienttemplate;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TweetAdapter$ViewHolder_ViewBinding<T extends TweetAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public TweetAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.ivProfileImage = Utils.findRequiredViewAsType(source, R.id.ivProfileImage, "field 'ivProfileImage'", ImageView.class);
    target.tvUsername = Utils.findRequiredViewAsType(source, R.id.tvUserName, "field 'tvUsername'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tvTime, "field 'tvTime'", TextView.class);
    target.tvBody = Utils.findRequiredViewAsType(source, R.id.tvBody, "field 'tvBody'", TextView.class);
    target.tvNumLikes = Utils.findRequiredViewAsType(source, R.id.tvNumLikes, "field 'tvNumLikes'", TextView.class);
    target.tvNumRetweet = Utils.findRequiredViewAsType(source, R.id.tvNumRetweet, "field 'tvNumRetweet'", TextView.class);
    target.tvScreenName = Utils.findRequiredViewAsType(source, R.id.tvScreenName, "field 'tvScreenName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivProfileImage = null;
    target.tvUsername = null;
    target.tvTime = null;
    target.tvBody = null;
    target.tvNumLikes = null;
    target.tvNumRetweet = null;
    target.tvScreenName = null;

    this.target = null;
  }
}
