package com.malku.app.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malku.app.persistence.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
