package com.graysan.data.entity;

import com.graysan.auditing.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//Lombok
@Data
@Log4j2
@ToString
//Entity
@Entity
@Table(name = "categories")
public class CategoryEntity extends AuditingAwareBaseEntity implements Serializable {

    // serileştirme
    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id",unique = true,nullable = false,insertable = true,updatable = false)
    private Long categoryId;

    // CATEGORY NAME
    @Column(name = "category_name")
    private String categoryName;

    // DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    // RELATION
    @OneToMany(mappedBy = "relationCategoryEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<BlogEntity> relationBlogEntityList;

    // Constructor (parametresiz)
    public CategoryEntity() {
    }

    // Constructor (parametreli)
    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }

    // Constructor (parametreli)
    public CategoryEntity(String categoryName, List<BlogEntity> relationBlogEntityList) {
        this.categoryName = categoryName;
        this.relationBlogEntityList = relationBlogEntityList;
    }
} //end class
