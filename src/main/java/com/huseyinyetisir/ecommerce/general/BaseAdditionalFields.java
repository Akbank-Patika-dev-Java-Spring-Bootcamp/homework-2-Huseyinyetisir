package com.huseyinyetisir.ecommerce.general;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

    @Column(name = "ID_USER_CREATED_BY")
    private Long createdBy;

    @Column(name = "ID_USER_UPDATED_BY")
    private Long updatedBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATED_DATE")
    private LocalDateTime updateDate;
}
