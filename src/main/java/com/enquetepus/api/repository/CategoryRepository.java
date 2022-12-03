package com.enquetepus.api.repository;

import com.enquetepus.api.entities.CategoryPost;
import com.enquetepus.api.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryPost, Long> {


}
