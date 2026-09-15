package com.likelion.springsession_hw.post.repository;

import com.likelion.springsession_hw.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{
}
