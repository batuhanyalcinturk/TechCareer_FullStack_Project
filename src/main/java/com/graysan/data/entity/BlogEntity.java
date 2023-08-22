package com.graysan.data.entity;

import com.graysan.auditing.AuditingAwareBaseEntity;
import com.graysan.data.BlogEntityEmbeddable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
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

}
