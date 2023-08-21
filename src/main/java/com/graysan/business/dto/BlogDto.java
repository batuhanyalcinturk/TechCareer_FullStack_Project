package com.graysan.business.dto;

import com.graysan.auditing.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class BlogDto extends AuditingAwareBaseDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    // Header
    @NotEmpty(message = "{blog.header.validation.constraints.NotNull.message}")
    @Size(min = 10, message = "{blog.header.least.validation.constraints.NotNull.message}")
    private String header;

    // Content
    @NotEmpty(message = "{blog.content.validation.constraints.NotNull.message}")
    @Size(min = 10, message = "{blog.content.least.validation.constraints.NotNull.message}")
    private String content;

}
