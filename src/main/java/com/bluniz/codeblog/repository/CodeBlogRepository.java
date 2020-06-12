package com.bluniz.codeblog.repository;

import com.bluniz.codeblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeBlogRepository extends JpaRepository<Post, Long> {

}
