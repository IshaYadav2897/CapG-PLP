package com.cg.CafeDetails.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.CafeDetails.dto.CafeDetails;
import com.cg.CafeDetails.dto.CafeMenu;
import com.cg.CafeDetails.exception.CafeDetailsNotFoundException;
import com.cg.CafeDetails.service.CafeDetailsService;

@RestController
@RequestMapping(value = "/cafedetails")
public class CafeDetailsController {

	@Autowired
	private CafeDetailsService service;
	
	@PostMapping(value = "add", consumes = "application/json", produces = "application/json")
	public CafeDetails addCafeDetails(@RequestBody CafeDetails cafedetails) {
//		System.out.println(cafedetails);
		return service.addCafeDetails(cafedetails);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public CafeDetails fetchCafeDetailsById(@PathVariable int id) throws CafeDetailsNotFoundException {
		return service.fetchCafeDetailsById(id);
	}
	
	@GetMapping(value = "fetchAllCafe", produces = "application/json")
	public List<CafeDetails> fetchAllCafeDetails() {
		return service.fetchAllCafeDetails();
	}
	
	@DeleteMapping(value = "remove", produces = "application/json")
	public boolean removeCafeDetails(@RequestParam int id) throws CafeDetailsNotFoundException {
		return service.removeCafeDetails(id);
	}
	
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public CafeDetails updateCafeDetails(@RequestBody CafeDetails cafedetails) {
		return service.updateCafeDetails(cafedetails);
	}
	
	
	
	
	@GetMapping(value = "/byName/{name}", produces = "application/json")
	public List<CafeDetails> fetchAllCafeDetailsByName(@PathVariable String name) {
		return service.fetchCafeDetailsByName(name);
	}
	
	@GetMapping(value = "/byLocation/{location}", produces = "application/json")
	public CafeDetails fetchAllCafeDetailsByLocation(@PathVariable String location) {
		return service.fetchCafeDetailsByLocation(location);
	}
	
	@GetMapping(value = "/byOwner/{owner}", produces = "application/json")
	public List<CafeDetails> fetchAllCafeDetailsByOwner(@PathVariable String owner) {
		return service.fetchCafeDetailsByOwner(owner);
	}
	
	@GetMapping(value = "/byRating/{rating}", produces = "application/json")
	public List<CafeDetails> fetchAllCafeDetailsByRating(@PathVariable double rating) {
		return service.fetchCafeDetailsByRating(rating);
	}
	
	@GetMapping(value = "/byRatingRange/{min}/{max}", produces = "application/json")
	public List<CafeDetails> fetchAllCafeDetailsByRatingRange(@PathVariable double min, @PathVariable double max) {
		return service.fetchCafeDetailsByRatingRange(min, max);
	}
	
	@GetMapping(value = "/sort", produces = "application/json")
	public List<CafeDetails> sortAllCafeDetailsByRating() {
		return service.sortCafeDetailsByRating();
	}
	
	@PutMapping(value = "/updateName/{id}/{name}", produces = "application/json")
	public int updateCafeName(@PathVariable int id, @PathVariable String name) throws CafeDetailsNotFoundException {
		return service.updateCafeName(name, id);
	}
	
	
	
	
	
	@GetMapping(value = "/menuId/{id}", produces = "application/json")
	public CafeMenu fetchCafeMenuById(@PathVariable int id) {
		return service.fetchCafeMenuById(id);
	}
	
	@GetMapping(value = "fetchAllMenu", produces = "application/json")
	public List<CafeMenu> fetchAllCafeMenu() {
		return service.fetchAllCafeMenu();
	}
}
