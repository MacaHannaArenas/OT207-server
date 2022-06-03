package com.alkemy.ong.dto;

import com.alkemy.ong.model.Organization;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SlidesResponseDTO {

    private Long id;
    private String imageUrl;
    private String text;
    private Integer orderSlides;
    private Organization organizations;
}
