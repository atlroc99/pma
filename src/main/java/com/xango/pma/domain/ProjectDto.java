package com.xango.pma.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDto {
    private String name;
    private String stage;
    private String description;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date createdOn;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date modifiedOn;
}
