package com.praba.myproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.praba.myproject.model.UserData;

@Repository
public interface LoginRepository extends CrudRepository<UserData, Long> {

	@Query("SELECT u FROM UserData u where u.userId=:userId and u.password=:password")
	public Optional<UserData> findByUserIdAndPassword(@Param("userId") String userId, @Param("password") String password);
}
