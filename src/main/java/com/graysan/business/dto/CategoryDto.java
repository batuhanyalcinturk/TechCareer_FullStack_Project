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
// Category (1) - Blog (N)
public class CategoryDto extends AuditingAwareBaseDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    // Category Name
    @NotEmpty(message = "{blog.category.validation.constraints.NotNull.message}")
    @Size(min = 10, message = "{blog.category.least.validation.constraints.NotNull.message}")
    private String categoryName;
}
