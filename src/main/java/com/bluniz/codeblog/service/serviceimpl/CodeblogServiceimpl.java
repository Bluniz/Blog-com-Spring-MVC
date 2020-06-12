package com.bluniz.codeblog.service.serviceimpl;

import com.bluniz.codeblog.model.Post;
import com.bluniz.codeblog.repository.CodeBlogRepository;
import com.bluniz.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeblogServiceimpl implements CodeblogService {

    @Autowired
    CodeBlogRepository codeBlogRepository;


    @Override
    public List<Post> findAll() {
        return codeBlogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return codeBlogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeBlogRepository.save(post);
    }
}
