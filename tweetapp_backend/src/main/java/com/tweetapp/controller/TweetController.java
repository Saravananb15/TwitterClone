package com.tweetapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.request.TweetRequest;
import com.tweetapp.response.TweetResponse;
import com.tweetapp.service.TweetsService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TweetController {

	@Autowired
	TweetsService tweetsService;

//	@Autowired
//	Producer producer;

	private final Logger logger = LoggerFactory.getLogger(TweetController.class);

	@GetMapping(value = "/api/v1.0/tweets/all")
	public TweetResponse getAllTweets() {
		TweetResponse response = tweetsService.getAllTweets();
		logger.info("Tweet Controller" + "in get All Tweets() call" + response.getStatusMessage());
		return response;
	}

	@GetMapping(value = "/api/v1.0/tweets/{username}")
	public TweetResponse getAllTweetsUser(@PathVariable("username") String userName) {
		TweetResponse response = tweetsService.getAllTweetsByUserName(userName);
		logger.info("Tweet Controller" + "in get All Tweets() call" + response.getStatusMessage());
		return response;

	}

	@PostMapping(value = "/api/v1.0/tweets/{username}/add")
	public TweetResponse addTweet(@RequestBody TweetRequest request, @PathVariable("username") String userName) {
		//producer.sendMessage(request.getTweet().getTweet());
		TweetResponse response = tweetsService.addTweet(request, userName);
		logger.info("Tweet Controller" + "in addTweet() call" + response.getStatusMessage());
		return response;
	}

	@RequestMapping(path = "/api/v1.0/tweets/{username}/delete/{id}", method = RequestMethod.DELETE)
	public TweetResponse deleteTweet(@PathVariable("username") String userName, @PathVariable("id") String tweetId) {
		TweetResponse response = tweetsService.deleteTweet(userName, tweetId);
		logger.info("Tweet Controller" + "in deleteTweet() call" + response.getStatusMessage());
		return response;

	}

	@PostMapping(value = "/api/v1.0/tweets/reply")
	public TweetResponse replyToTweet(@RequestBody TweetRequest request) {
		//producer.sendMessage(request.getTweet().getReply().get(0).getReplied());
		TweetResponse response = tweetsService.replyToTweet(request);
		logger.info("Tweet Controller" + "in replyToTweet() call" + response.getStatusMessage());
		return response;
	}

	@RequestMapping(value = "/api/v1.0/tweets/like", method = RequestMethod.POST)
	public TweetResponse likeATweet(@RequestBody TweetRequest request) {
		TweetResponse response = tweetsService.likeATweet(request);
		logger.info("Tweet Controller" + "in likeATweet() call" + response.getStatusMessage());
		return response;
	}

	@RequestMapping(value = "/api/v1.0/tweets/update", method = RequestMethod.POST)
	public TweetResponse updateTweet(@RequestBody TweetRequest request) {
		//producer.sendMessage(request.getTweet().getTweet());
		TweetResponse response = tweetsService.updateTweet(request);
		logger.info("Tweet Controller" + "in updateTweet() call" + response.getStatusMessage());
		return response;
	}

}
