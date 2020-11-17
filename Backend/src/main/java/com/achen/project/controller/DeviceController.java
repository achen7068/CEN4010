package com.achen.project.controller;

import com.achen.project.dto.AdminCredentialsDTO;
import com.achen.project.dto.AlertDTO;
import com.achen.project.dto.DeviceDTO;
import com.achen.project.security.repository.UserRepository;
import com.achen.project.security.repository.entity.QUser;
import com.achen.project.security.repository.entity.User;
import com.achen.project.service.DeviceService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@RestController
@RequestMapping("/device")
@CrossOrigin
public class DeviceController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DeviceService deviceService;
    @PostMapping("/create")
    public ResponseEntity<DeviceDTO> createDevice(@RequestBody @Valid DeviceDTO deviceDTO){
        return deviceService.createDevice(deviceDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<List<DeviceDTO>> getAllDevices(){
        return deviceService.getAllDevices();
    }
    @PutMapping("/edit")
    public ResponseEntity<DeviceDTO> editDevice(@RequestBody @Valid DeviceDTO deviceDTO){
        return deviceService.editDevice(deviceDTO);
    }
    @GetMapping("/alert")
    public ResponseEntity<List<DeviceDTO>> getAlertDevices(){
        return deviceService.getAllAlertDevices();
    }

    @PostMapping("/alert")
    public ResponseEntity changeStatusToAlert(@RequestBody AlertDTO deviceId){
        deviceService.changeStatusToAlert(deviceId);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/admin")
    public ResponseEntity checkAdminCredentials (@RequestBody AdminCredentialsDTO adminCredentialsDTO){
        final User user = userRepository.findOne(
                QUser.user.email.eq(adminCredentialsDTO.getEmail())
        ).orElseThrow(() -> new RuntimeException("Invalid Credentials Of Admin"));
        if(user.getPassword().compareTo(adminCredentialsDTO.getPassword())==0)
            return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.BAD_REQUEST);

    }
}
