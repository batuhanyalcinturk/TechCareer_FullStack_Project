package com.graysan.auditing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
abstract public class AuditingAwareBaseDto  implements Serializable {

    public static final Long serialVersionUID = 1L;

    // ID
    private Long id;

    // Date
    @Builder.Default
    private Date systemDate = new Date(System.currentTimeMillis());

    // AUDITING
    @JsonIgnore // Backende veri giderken bu bilgiyi gösterme
    protected String createdUser;
    @JsonIgnore
    protected Date createdDate;

    protected String updatedUser;

    protected Date updatedDate;
}
