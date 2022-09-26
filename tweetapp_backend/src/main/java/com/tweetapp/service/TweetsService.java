package com.tweetapp.service;

import com.tweetapp.request.TweetRequest;
import com.tweetapp.response.TweetResponse;

public interface TweetsService {

	TweetResponse getAllTweets();

	TweetResponse getAllTweetsByUserName(String userName);

	TweetResponse addTweet(TweetRequest request, String userName);

	TweetResponse deleteTweet(String userName, String tweetId);

	TweetResponse replyToTweet(TweetRequest request);

	TweetResponse likeATweet(TweetRequest request);

	TweetResponse updateTweet(TweetRequest request);

}
