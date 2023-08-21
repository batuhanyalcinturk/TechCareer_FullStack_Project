package com.graysan.data.entity;

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
public class BlogEntity implements Serializable {

    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id", unique = true, nullable = false, insertable = true, updatable = false)
    private Long blogId;

    // Header
    @Column(name = "header", length = 500, columnDefinition = "varchar(500) default 'başlık yazılmadı... '")
    private String header;

    // Content
    @Lob
    private String content;

    // Date
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    /* DB de olmasın Javada olsun
    @Transient
    private String justJava;
    */

}
