package com.tweetapp.repo;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.entities.UsersEntity;

@Repository
@EnableScan
public interface UsersRepo extends CrudRepository<UsersEntity, String> {

//	@Query("{'loginId':?0}")
	UsersEntity findByLoginId(String loginId);

//	@Query("{'loginId':{'$regex':?0,$options:'i'}}")
//	List<UsersEntity> searchByIds(String username);

//	@Query("{'loggedIn':true}")
//	List<UsersEntity> findAllLoggedIn();

}
