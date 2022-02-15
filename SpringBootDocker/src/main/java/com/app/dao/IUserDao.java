package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface IUserDao extends JpaRepository<User, Integer>{
	//User validateUser(String email,String pwd);
	//special finsder methods
	Optional<User>  findByEmailAndPassword(String email,String pwd);
}
