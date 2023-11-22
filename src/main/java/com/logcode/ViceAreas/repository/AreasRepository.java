package com.logcode.ViceAreas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logcode.ViceAreas.model.Areas;

@Repository
public interface AreasRepository extends JpaRepository<Areas, Long> {

}
