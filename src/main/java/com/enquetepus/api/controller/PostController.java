package com.enquetepus.api.controller;

import com.enquetepus.api.dto.PostDto;
import com.enquetepus.api.entities.CategoryPost;
import com.enquetepus.api.entities.Post;
import com.enquetepus.api.repository.CategoryRepository;
import com.enquetepus.api.repository.PostRepository;
import com.enquetepus.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class PostController {
  @Autowired
    private PostRepository postRepository;
  @Autowired
  private  PostService postService;
  @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping("/post")
    public Post savePost(@RequestBody PostDto postDto){
       // System.out.print("categoryId: " + postDto.getCategoryId());
     CategoryPost categoryPost = categoryRepository.findById(postDto.getCategoryId()).orElse(null);

        Post postToSave = new Post();
        postToSave.setId(postDto.getCategoryId());
        postToSave.setName(postDto.getName());
        postToSave.setTitle(postDto.getTitle());
        postToSave.setText(postDto.getText());
        postToSave.setUrl(postDto.getUrl());

        postToSave.setCategoryPost(categoryPost);
        return  postRepository.save(postToSave);
    }


    @GetMapping("/postPage")
    public Page postPageable(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @PostMapping("/category")
    public CategoryPost saveCategory(@RequestBody CategoryPost categoryPost){
        return  categoryRepository.save(categoryPost);
    }

    @GetMapping("/category")
    public List<CategoryPost> categoryList(){
        return  categoryRepository.findAll();
    }
    @GetMapping("/category/{id}")
    public Optional<CategoryPost> findCatById(@PathVariable("id")  Long id){
        return  categoryRepository.findById(id);
    }

    @GetMapping("/post")
    public List<Post> postList(){
        return  postRepository.findAll();
    }


    @GetMapping("/post/{id}")
    public Optional<Post> getPostById(@PathVariable("id")  Long id){
        return  postRepository.findById(id);
    }

    @PutMapping("/post/{id}")
    public Post updatePost(@RequestBody Post post,@PathVariable("id") Long id)
    {
        return postService.updatePost(post, id);
    }



    @GetMapping("/search")
    public List<Post> getPostName(@RequestParam String name) {
        return postRepository.findPostByName(name);
    }

    @GetMapping("/postMc")
    public Page<Post> getPost(String mc, int page) {
        return  postRepository.postMc("%"+mc+"%", Pageable.ofSize(page));

    }






     @DeleteMapping("/post/{id}")
     public String deletePostById(@PathVariable("id") Long id)
    {
         postService.deletePostById(id);
         return "Deleted Successfully";
     }




}


//<p class="category" *ngFor="let user of users; let i = index">Number of users: {{i}}. {{item}}</p>
