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

    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id", unique = true, nullable = false, insertable = true, updatable = false)
    private Long blogId;

    @Embedded
    private BlogEntityEmbeddable blogEntityEmbeddable = new BlogEntityEmbeddable();

    // Date
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    /* DB de olmasın Javada olsun
    @Transient
    private String justJava;
    */

    // RELATION
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    CategoryEntity relationCategoryEntity;

    // CONSTRUCTOR


    public BlogEntity() {
    }

    public BlogEntity(BlogEntityEmbeddable blogEntityEmbeddable, CategoryEntity relationCategoryEntity) {
        this.blogEntityEmbeddable = blogEntityEmbeddable;
        this.relationCategoryEntity = relationCategoryEntity;
    }
}
