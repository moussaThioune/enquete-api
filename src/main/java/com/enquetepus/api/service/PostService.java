package com.enquetepus.api.service;

import com.enquetepus.api.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    Post savePost(Post post);

    List<Post> fetchPostList();

    Post updatePost(Post post,Long id);

    void deletePostById(Long id);


}
