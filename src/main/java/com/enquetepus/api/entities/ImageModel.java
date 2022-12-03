package com.enquetepus.api.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column

    @Lob
    private byte[] data;

    public ImageModel() {
        super();
    }

    public ImageModel(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

}
