package com.graysan.data.entity;

import com.graysan.auditing.AuditingAwareBaseEntity;
import com.graysan.data.BlogEntityEmbeddable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

//Lombok
@Data
@Log4j2
@ToString
//Entity
@Entity
@Table(name = "blogs")
public class BlogEntity extends AuditingAwareBaseEntity implements Serializable {

    // serileştirme
    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="blog_id",unique = true,nullable = false,insertable = true,updatable = false)
    private Long blogId;

    // Embedded
    @Embedded
    private BlogEntityEmbeddable blogEntityEmbeddable=new BlogEntityEmbeddable();

    //  RELATION
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="category_id",nullable = false)
    private CategoryEntity relationCategoryEntity;

    // Constructor (Parametresiz)
    public BlogEntity() {
    }

    // Constructor (Parametreli)
    public BlogEntity(BlogEntityEmbeddable blogEntityEmbeddable, CategoryEntity relationCategoryEntity) {
        this.blogEntityEmbeddable = blogEntityEmbeddable;
        this.relationCategoryEntity = relationCategoryEntity;
    }
} //end class
