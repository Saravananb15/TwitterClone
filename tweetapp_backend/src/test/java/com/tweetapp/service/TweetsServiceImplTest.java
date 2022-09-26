//package com.tweetapp.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.doThrow;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.bson.types.ObjectId;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.HttpServerErrorException.InternalServerError;
//
//import com.tweetapp.config.TweetConfigTest;
//import com.tweetapp.dto.Reply;
//import com.tweetapp.dto.TweetsDto;
//import com.tweetapp.entities.TweetsEntity;
//import com.tweetapp.repo.TweetsRepo;
//import com.tweetapp.request.TweetRequest;
//import com.tweetapp.response.TweetResponse;
//import com.tweetapp.service.impl.TweetsServiceImpl;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = TweetsServiceImpl.class)
//@ContextConfiguration(classes = TweetConfigTest.class)
//public class TweetsServiceImplTest {
//
//	@SpyBean
//	private TweetsServiceImpl tweetsServiceImpl;
//
//	@MockBean
//	TweetsRepo tweetsRepo;
//
//	@Test
//	public void getAllTweetsTest() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("SUCCESS");
//		List<TweetsEntity> tweets = new ArrayList<>();
//		List<Reply> replies = new ArrayList<>();
//		TweetsEntity entity = new TweetsEntity();
//		entity.setDateOfPost(new Date());
//		entity.setLike(1L);
//		entity.setReply(replies);
//		entity.setTweet("Hi");
//		entity.setTweetId(1l);
//		entity.setUserTweetId("finny");
//		tweets.add(entity);
//		Mockito.when(tweetsRepo.findAll()).thenReturn(tweets);
//		TweetResponse actualResponse = tweetsServiceImpl.getAllTweets();
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//
//	@Test
//	public void getAllTweetsTestException() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("FAILURE");
//		Mockito.when(tweetsRepo.findAll()).thenThrow(InternalServerError.class);
//		TweetResponse actualResponse = tweetsServiceImpl.getAllTweets();
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//
//	@Test
//	public void getAllTweetsbyUserNameTest() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("SUCCESS");
//		List<TweetsEntity> tweets = new ArrayList<>();
//		List<Reply> replies = new ArrayList<>();
//		TweetsEntity entity = new TweetsEntity();
//		entity.set_id(new ObjectId());
//		entity.setDateOfPost(new Date());
//		entity.setLike(1L);
//		entity.setReply(replies);
//		entity.setTweet("Hi");
//		entity.setTweetId(1l);
//		entity.setUserTweetId("finny");
//		tweets.add(entity);
//		Mockito.when(tweetsRepo.findByUserName("finny")).thenReturn(tweets);
//		TweetResponse actualResponse = tweetsServiceImpl.getAllTweetsByUserName("finny");
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//
//	@Test
//	public void getAllTweetsbyUserNameTestException() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("FAILURE");
//		Mockito.when(tweetsRepo.findByUserName("finny")).thenThrow(InternalServerError.class);
//		TweetResponse actualResponse = tweetsServiceImpl.getAllTweetsByUserName("finny");
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//
//	@Test
//	public void addTweetTest() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("SUCCESS");
//		TweetRequest request = new TweetRequest();
//		TweetsDto tweet = new TweetsDto();
//		List<Reply> replies = new ArrayList<>();
//		tweet.setDateOfPost("26/04/2021");
//		tweet.setLike(1l);
//		tweet.setReply(replies);
//		tweet.setTweet("");
//		tweet.setTweetId(1l);
//		tweet.setUserTweetId("finny");
//		request.setTweet(tweet);
//		TweetResponse actualResponse = tweetsServiceImpl.addTweet(request, "finny");
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//
//	@Test
//	public void addTweetTest1() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("SUCCESS");
//		TweetRequest request = new TweetRequest();
//		TweetsDto tweet = new TweetsDto();
//		List<Reply> replies = new ArrayList<>();
//		tweet.setDateOfPost("26/04/2021");
//		tweet.setLike(1l);
//		tweet.setReply(replies);
//		tweet.setTweet("");
//		tweet.setTweetId(1l);
//		tweet.setUserTweetId("finny");
//		request.setTweet(tweet);
//		TweetsEntity entity = new TweetsEntity();
//		entity.setTweetId(1l);
//		Mockito.when(tweetsRepo.findTopByOrderByTweetIdDesc()).thenReturn(entity);
//		TweetResponse actualResponse = tweetsServiceImpl.addTweet(request, "finny");
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//
//	@Test
//	public void addTweetTestException() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("FAILURE");
//		TweetRequest request = new TweetRequest();
//		TweetsDto tweet = new TweetsDto();
//		List<Reply> replies = new ArrayList<>();
//		tweet.setDateOfPost("26/04/2021");
//		tweet.setLike(1l);
//		tweet.setReply(replies);
//		tweet.setTweet("");
//		tweet.setTweetId(1l);
//		tweet.setUserTweetId("finny");
//		request.setTweet(tweet);
//		Mockito.when(tweetsRepo.findTopByOrderByTweetIdDesc()).thenThrow(InternalServerError.class);
//		TweetResponse actualResponse = tweetsServiceImpl.addTweet(request, "finny");
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	@Test
//	public void deleteTweetTest() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("SUCCESS");
//		TweetResponse actualResponse = tweetsServiceImpl.deleteTweet("finny",1l);
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	@Test
//	public void deleteTweetTestException() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("FAILURE");
//		doThrow(InternalServerError.class).when(tweetsRepo).deleteByTweetId(1l);
//		TweetResponse actualResponse = tweetsServiceImpl.deleteTweet("finny",1l);
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	@Test
//	public void replyToTweetTest() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("SUCCESS");
//		TweetRequest request = new TweetRequest();
//		TweetsDto tweet = new TweetsDto();
//		List<Reply> replies = new ArrayList<>();
//		Reply reply = new Reply();
//		reply.setUserId("bud");
//		reply.setReplied("hello");
//		reply.setDateReplied(new Date());
//		replies.add(reply);
//		tweet.setTweetId(1l);
//		tweet.setReply(replies);
//		request.setTweet(tweet);
//		TweetsEntity entity = new TweetsEntity();
//		entity.setTweetId(1l);
//		entity.setReply(replies);
//		Mockito.when(tweetsRepo.findByTweetId(1l)).thenReturn(entity);
//		TweetResponse actualResponse = tweetsServiceImpl.replyToTweet(request);
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	@Test
//	public void replyToTweetTestException() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("FAILED");
//		TweetRequest request = new TweetRequest();
//		TweetsDto tweet = new TweetsDto();
//		List<Reply> replies = new ArrayList<>();
//		Reply reply = new Reply();
//		reply.setUserId("bud");
//		reply.setReplied("hello");
//		reply.setDateReplied(new Date());
//		replies.add(reply);
//		request.setTweet(tweet);
//		Mockito.when(tweetsRepo.findByTweetId(1l)).thenThrow(InternalServerError.class);
//		TweetResponse actualResponse = tweetsServiceImpl.replyToTweet(request);
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//
//	@Test
//	public void likeTweetTest() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("SUCCESS");
//		TweetRequest request = new TweetRequest();
//		TweetsDto tweet = new TweetsDto();
//		tweet.setTweetId(1l);
//		request.setTweet(tweet);
//		TweetsEntity entity = new TweetsEntity();
//		entity.setTweetId(1l);
//		entity.setLike(1l);
//		Mockito.when(tweetsRepo.findByTweetId(1l)).thenReturn(entity);
//		TweetResponse actualResponse = tweetsServiceImpl.likeATweet(request);
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	@Test
//	public void likeTweetTestException() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("FAILURE");
//		TweetRequest request = new TweetRequest();
//		TweetsDto tweet = new TweetsDto();
//		tweet.setTweetId(1l);
//		request.setTweet(tweet);
//		Mockito.when(tweetsRepo.findByTweetId(1l)).thenThrow(InternalServerError.class);
//		TweetResponse actualResponse = tweetsServiceImpl.likeATweet(request);
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	@Test
//	public void updateTweetTest() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("SUCCESS");
//		TweetRequest request = new TweetRequest();
//		TweetsDto tweet = new TweetsDto();
//		tweet.setTweetId(1l);
//		tweet.setTweet("Helo");
//		request.setTweet(tweet);
//		TweetsEntity entity = new TweetsEntity();
//		entity.setTweetId(1l);
//		entity.setLike(1l);
//		Mockito.when(tweetsRepo.findByTweetId(1l)).thenReturn(entity);
//		TweetResponse actualResponse = tweetsServiceImpl.updateTweet(request);
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	@Test
//	public void updateTweetTestException() {
//		TweetResponse response = new TweetResponse();
//		response.setStatusMessage("FAILURE");
//		TweetRequest request = new TweetRequest();
//		TweetsDto tweet = new TweetsDto();
//		tweet.setTweetId(1l);
//		tweet.setTweet("Helo");
//		request.setTweet(tweet);
//		Mockito.when(tweetsRepo.findByTweetId(1l)).thenThrow(InternalServerError.class);
//		TweetResponse actualResponse = tweetsServiceImpl.updateTweet(request);
//		assertEquals(response.getStatusMessage(), actualResponse.getStatusMessage());
//	}
//	
//	
//	
//
//}
