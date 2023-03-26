package com.malku.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malku.app.persistence.entity.MediaFinder;

@Repository
public interface MediaFinderRepository extends JpaRepository<MediaFinder, Integer> {

	
	MediaFinder findBySlug(String string);

}
