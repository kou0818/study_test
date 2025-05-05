package com.jutjoy.domain.repository.news;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jutjoy.domain.entity.news.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
	
	// 2-4で追記
	public List<News> findAllByOrderById();
	
	// 2-4で追記
	public List<News> findByTitleLike(String title);
	
}