package com.enquetepus.api.service;

import com.enquetepus.api.entities.Post;
import com.enquetepus.api.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> fetchPostList() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Post post, Long id) {
        Post post1 = postRepository.findById(id).get();
        post1.setId(post.getId());
        post1.setName(post.getName());
        post1.setText(post.getText());
        post1.setTitle(post.getTitle());
        post1.setUrl(post.getUrl());
        post1.setCategoryPost(post.getCategoryPost());
        return postRepository.save(post1) ;
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);

    }


}
