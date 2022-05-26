package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.OrganizationDTO;
import com.alkemy.ong.model.Organization;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationMapper {

    public OrganizationDTO oganizationEntity2DTO(@NotNull Organization entity) {
        OrganizationDTO dto = new OrganizationDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        return dto;
    }

    public List<OrganizationDTO> organizationEntityList2DTOList(@NotNull @NotEmpty List<Organization> entities) {
        List<OrganizationDTO> dtoList = new ArrayList<>();
        for (Organization entity : entities) {
            dtoList.add(this.oganizationEntity2DTO(entity));
        }
        return dtoList;
    }
}
