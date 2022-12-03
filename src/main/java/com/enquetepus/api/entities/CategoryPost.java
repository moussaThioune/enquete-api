package com.enquetepus.api.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder
public class CategoryPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    @OneToMany(mappedBy = "categoryPost", fetch = FetchType.LAZY)
    private List<Post> posts;
}
