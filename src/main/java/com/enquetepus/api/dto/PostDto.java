package com.enquetepus.api.dto;


import lombok.Data;

@Data
public class PostDto {
    private  String name;
    private  String text;
    private  String title;
    private  String  url;
    private Long categoryId;
}
