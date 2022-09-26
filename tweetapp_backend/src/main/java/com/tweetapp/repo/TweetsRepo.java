package com.tweetapp.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.entities.TweetsEntity;

@EnableScan
@Repository
public interface TweetsRepo extends CrudRepository<TweetsEntity, String> {

//	@Query("Select e From TweetsEntity e where e.user_tweet_id = :")
//	List<TweetsEntity> findByuserName();

//	@Query("{'userTweetId' : ?0}")
	List<TweetsEntity> findByUserTweetId(String userName);

//	@DeleteQuery(value="{'tweetId' : ?0}")
	void deleteByTweetId(Long tweetId);

//	@Query("{ 'tweetId' : ?0 }, { $push : { 'reply' : {reply.1:[{'userId':'bud','replied':'wow'}]}}")
//	void postReply(String tweetId, List<Reply> reply);

	//@Query("{'tweetId' : ?0}")
	TweetsEntity findByTweetId(Long tweetId);
	
	TweetsEntity findTopByOrderByTweetIdDesc();

}
