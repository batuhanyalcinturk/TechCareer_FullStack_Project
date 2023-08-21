package com.graysan.data;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

//LOMBOK
@Getter
@Setter

@Embeddable
public class BlogEntityEmbeddable {
    // Header
    @Column(name = "header", length = 500, columnDefinition = "varchar(500) default 'başlık yazılmadı... '")
    private String header;

    private String image;
    private String title;

    // Content
    @Lob
    private String content;
}
