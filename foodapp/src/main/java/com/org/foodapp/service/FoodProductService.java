package com.org.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.foodapp.dao.FoodProductDao;
import com.org.foodapp.dto.FoodProduct;
import com.org.foodapp.util.ResponseStructure;

@Service
public class FoodProductService {
	
	@Autowired
	FoodProductDao foodProductDao;
	
	public  ResponseEntity<ResponseStructure<FoodProduct>> savefFoodProduct(FoodProduct foodProduct) {
		ResponseStructure<FoodProduct> structure = new ResponseStructure<>();
		structure.setError(false);
		structure.setMessage("Food Product Saved");
		structure.setData(foodProductDao.saveFoodProduct(foodProduct));
		
		return new ResponseEntity<ResponseStructure<FoodProduct>>(structure, HttpStatus.OK);
	}

}
