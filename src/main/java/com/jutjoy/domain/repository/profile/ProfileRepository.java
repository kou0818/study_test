package com.jutjoy.domain.repository.profile;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jutjoy.domain.entity.profile.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	//2-4課題
	public List<Profile> findAllByOrderById();
	
	public List<Profile> findByNameLike(String name);
	
}