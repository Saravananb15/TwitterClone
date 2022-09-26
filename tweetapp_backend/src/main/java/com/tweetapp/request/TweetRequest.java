package com.tweetapp.request;

import com.tweetapp.dto.TweetsDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TweetRequest {

	private TweetsDto tweet;

	public TweetsDto getTweet() {
		return tweet;
	}

	public void setTweet(TweetsDto tweet) {
		this.tweet = tweet;
	}
}
