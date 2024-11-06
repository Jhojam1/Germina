package com.Germina.Germina.domain.Mapper;

import com.Germina.Germina.domain.Dtos.TempUserDTO;
import com.Germina.Germina.persistence.entities.TempUser;

public class TempUserMapper {

    public static TempUser toEntity(TempUserDTO tempUserDTO) {
        TempUser tempUser = new TempUser();
        tempUser.setId(tempUserDTO.getId());
        tempUser.setFullName(tempUserDTO.getFullName());
        tempUser.setNumberIdentification(tempUserDTO.getNumberIdentification());
        tempUser.setMail(tempUserDTO.getMail());
        return tempUser;
    }

    public static TempUserDTO toDto(TempUser tempUser) {
        TempUserDTO tempUserDTO = new TempUserDTO();
        tempUserDTO.setId(tempUser.getId());
        tempUserDTO.setFullName(tempUser.getFullName());
        tempUserDTO.setNumberIdentification(tempUser.getNumberIdentification());
        tempUserDTO.setMail(tempUser.getMail());
        return tempUserDTO;
    }
}
