package com.cg.CafeDetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.CafeDetails.dto.CafeMenu;

public interface CafeMenuRepo extends JpaRepository<CafeMenu, Integer> {

}
