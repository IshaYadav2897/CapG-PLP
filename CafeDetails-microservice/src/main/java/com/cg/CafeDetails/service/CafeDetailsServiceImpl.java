package com.cg.CafeDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.CafeDetails.dto.CafeDetails;
import com.cg.CafeDetails.dto.CafeMenu;
import com.cg.CafeDetails.exception.CafeDetailsNotFoundException;
import com.cg.CafeDetails.repo.CafeDetailsRepo;
import com.cg.CafeDetails.repo.CafeMenuRepo;

@Service
@Transactional(rollbackFor = CafeDetailsNotFoundException.class)
public class CafeDetailsServiceImpl implements CafeDetailsService {

	@Autowired
	private CafeDetailsRepo cafeDetailsRepo;
	
	@Autowired
	private CafeMenuRepo cafeMenuRepo;
	
	@Override
	public CafeDetails addCafeDetails(CafeDetails cafedetails) {
		return cafeDetailsRepo.save(cafedetails);
	}

	@Override
	public CafeDetails fetchCafeDetailsById(int cafeId) throws CafeDetailsNotFoundException {
		try {
			return cafeDetailsRepo.findById(cafeId).get();
		} catch (Exception e) {
			throw new CafeDetailsNotFoundException("No cafe details are available for cafeId: " + cafeId);
		}
	}

	@Override
	public List<CafeDetails> fetchAllCafeDetails() {
		return cafeDetailsRepo.findAll();
	}

	@Override
	public boolean removeCafeDetails(int cafeId) throws CafeDetailsNotFoundException {
		try {
			cafeDetailsRepo.deleteById(cafeId);
			return true;
		} catch (Exception e) {
			throw new CafeDetailsNotFoundException("Invalid Cafe Id provided: " + cafeId);
		}
	}

	@Override
	public CafeDetails updateCafeDetails(CafeDetails cafedetails) {
		return cafeDetailsRepo.save(cafedetails);
	}

	@Override
	public CafeMenu addCafeMenu(CafeMenu cafemenu) {
		return null;
	}

	@Override
	public CafeMenu fetchCafeMenuById(int itemId) {
		return cafeMenuRepo.findById(itemId).get();
	}

	@Override
	public List<CafeMenu> fetchAllCafeMenu() {
		return cafeMenuRepo.findAll();
	}

	@Override
	public boolean removeCafeMenu(int itemId) {
		return false;
	}

	@Override
	public CafeMenu updateCafeMenu(CafeMenu cafemenu) {
		return null;
	}

	
	
	
	@Override
	public List<CafeDetails> fetchCafeDetailsByName(String name) {
		return cafeDetailsRepo.fetchAllCafeDetailsByName(name);
	}

	@Override
	public CafeDetails fetchCafeDetailsByLocation(String location) {
		return cafeDetailsRepo.fetchCafeDetailsByLocation(location);
	}

	@Override
	public List<CafeDetails> fetchCafeDetailsByOwner(String owner) {
		return cafeDetailsRepo.fetchAllCafeDetailsByOwner(owner);
	}

	@Override
	public List<CafeDetails> fetchCafeDetailsByRating(double rating) {
		return cafeDetailsRepo.fetchAllCafeDetailsByRating(rating);
	}

	@Override
	public List<CafeDetails> fetchCafeDetailsByRatingRange(double min, double max) {
		return cafeDetailsRepo.fetchCafeDetailsByRatingRange(min, max);
	}

	@Override
	public List<CafeDetails> sortCafeDetailsByRating() {
		return cafeDetailsRepo.sortCafeDetailsByRating();
	}

	@Override
	public int updateCafeName(String name, int id) throws CafeDetailsNotFoundException {
		int updateStatus = cafeDetailsRepo.updateCafeName(name, id);
		if(updateStatus == 0)
			throw new CafeDetailsNotFoundException("Invalid Cafe Details are provided.");
		return 1;
	}

}
