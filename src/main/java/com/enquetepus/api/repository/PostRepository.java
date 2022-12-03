package com.enquetepus.api.repository;

import com.enquetepus.api.entities.CategoryPost;
import com.enquetepus.api.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
     List<Post> findPostByName(String name);

    List<Post> findByTitle(String title);


   @Query("SELECT p FROM Post p WHERE p.name LIKE %?1%")
         public List<Post> search(String keyword);
//            + " OR p.text LIKE %?1%"
//            + " OR p.title LIKE %?1%" + " OR CONCAT(p.id, '') LIKE %?1%")
//
//

//    @Query("select p from  Post p where p.name like :x")
//     Page<Post> postMc(@Param("x") String mc, Pageable p);


//    Page<Post> findByCategoryPost(CategoryPost categoryPost, Pageable pageable);
//    List<Post> findByName(String name);

}
