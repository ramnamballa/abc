package com.org.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.foodapp.dao.UserDao;
import com.org.foodapp.dto.User;
import com.org.foodapp.util.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setError(false);
		structure.setMessage(user.getName() + "saved");
		structure.setData(userDao.saveUser(user));
		
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<User>> getUserById(int id){
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> optional = userDao.getUserById(id);
		if(optional.isEmpty()) {
			System.out.println("No such id is found");
		}
		else {
			structure.setError(false);
			structure.setMessage("User Found");
			structure.setData(optional.get());
		}
		
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}

}
