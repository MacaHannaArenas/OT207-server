package com.alkemy.ong.repository;

import com.alkemy.ong.model.Slides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SlidesRepository extends JpaRepository<Slides, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM slides WHERE organization = ?1 ORDER BY order_slides")
    ArrayList<Slides> findSlideByOrganizationId(Long organizationId);

}