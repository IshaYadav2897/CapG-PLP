package com.cg.CafeDetails.service;

import java.util.List;

import com.cg.CafeDetails.dto.CafeDetails;
import com.cg.CafeDetails.dto.CafeMenu;
import com.cg.CafeDetails.exception.CafeDetailsNotFoundException;

public interface CafeDetailsService {

	CafeDetails addCafeDetails(CafeDetails cafedetails);
	
	CafeDetails fetchCafeDetailsById(int cafeId) throws CafeDetailsNotFoundException;
	
	List<CafeDetails> fetchAllCafeDetails();
	
	boolean removeCafeDetails(int cafeId) throws CafeDetailsNotFoundException;
	
	CafeDetails updateCafeDetails(CafeDetails cafedetails);
	
	
	
	List<CafeDetails> fetchCafeDetailsByName(String name);
	
	CafeDetails fetchCafeDetailsByLocation(String location);
	
	List<CafeDetails> fetchCafeDetailsByOwner(String owner);
	
	List<CafeDetails> fetchCafeDetailsByRating(double rating);
	
	List<CafeDetails> fetchCafeDetailsByRatingRange(double min, double max);
	
	List<CafeDetails> sortCafeDetailsByRating();
	
	int updateCafeName(String name, int id) throws CafeDetailsNotFoundException;
	
	
	
	CafeMenu addCafeMenu(CafeMenu cafemenu);
	
	CafeMenu fetchCafeMenuById(int itemId);
	
	List<CafeMenu> fetchAllCafeMenu();
	
	boolean removeCafeMenu(int itemId);
	
	CafeMenu updateCafeMenu(CafeMenu cafemenu);
}
