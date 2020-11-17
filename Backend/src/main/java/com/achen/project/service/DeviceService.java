package com.achen.project.service;

import com.achen.project.dto.AlertDTO;
import com.achen.project.dto.DeviceDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DeviceService {

    ResponseEntity<DeviceDTO> createDevice(DeviceDTO deviceDTO);
    ResponseEntity<List<DeviceDTO>> getAllDevices();
    ResponseEntity<DeviceDTO> editDevice(DeviceDTO deviceDTO);
    ResponseEntity<List<DeviceDTO>> getAllAlertDevices();
    void changeStatusToAlert(AlertDTO deviceId);
}
