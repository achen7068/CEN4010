package com.achen.project.security.service;


import com.achen.project.security.dto.InformationDto;
import org.springframework.http.ResponseEntity;

import java.security.Principal;

public interface InformationService {

    public ResponseEntity<InformationDto> updateInfo(Principal principal,
                                                     InformationDto informationDto);
}
