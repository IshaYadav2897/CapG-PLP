package com.cg.CafeDetails.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.CafeDetails.dto.CafeDetails;

public interface CafeDetailsRepo extends JpaRepository<CafeDetails, Integer>{

	@Query("SELECT c FROM CafeDetails c WHERE c.cafeName=:name")
	List<CafeDetails> fetchAllCafeDetailsByName(String name);
	
	@Query("SELECT c FROM CafeDetails c WHERE c.cafeLocation=:location")
	CafeDetails fetchCafeDetailsByLocation(String location);
	
	@Query("SELECT c FROM CafeDetails c WHERE c.cafeOwner=:owner")
	List<CafeDetails> fetchAllCafeDetailsByOwner(String owner);
	
	@Query("SELECT c FROM CafeDetails c WHERE c.cafeRating=:rating")
	List<CafeDetails> fetchAllCafeDetailsByRating(double rating);
	
	@Query("SELECT c FROM CafeDetails c WHERE c.cafeRating BETWEEN :min AND :max")
	List<CafeDetails> fetchCafeDetailsByRatingRange(double min, double max);
	
	@Query("SELECT c FROM CafeDetails c ORDER BY c.cafeRating")
	List<CafeDetails> sortCafeDetailsByRating();
	
	@Modifying
	@Query("UPDATE CafeDetails c SET c.cafeName=:name WHERE c.cafeId=:id")
	int updateCafeName(String name, int id);
}
