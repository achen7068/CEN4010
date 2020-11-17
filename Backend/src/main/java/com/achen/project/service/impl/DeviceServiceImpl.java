package com.achen.project.service.impl;

import com.achen.project.dto.AlertDTO;
import com.achen.project.dto.DeviceDTO;
import com.achen.project.repository.DeviceRepository;
import com.achen.project.repository.entity.Device;
import com.achen.project.repository.entity.QDevice;
import com.achen.project.service.DeviceService;
import io.jsonwebtoken.lang.Collections;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public ResponseEntity<DeviceDTO> createDevice(DeviceDTO deviceDTO) {
        Device device = modelMapper.map(deviceDTO,Device.class);
        device = deviceRepository.save(device);
        return new ResponseEntity<>(modelMapper.map(device,DeviceDTO.class), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DeviceDTO>> getAllDevices() {
        final List<Device> devices = deviceRepository.findAll();

        final List<DeviceDTO> deviceDTOS = devices.stream().map(device -> modelMapper.map(device,
                DeviceDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(deviceDTOS,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DeviceDTO> editDevice(DeviceDTO deviceDTO) {
        Device device = modelMapper.map(deviceDTO,Device.class);
        return new ResponseEntity<>(modelMapper.map(deviceRepository.save(device),DeviceDTO.class),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DeviceDTO>> getAllAlertDevices() {
        final Iterable<Device> devices = deviceRepository.findAll(QDevice.device.status.toLowerCase().eq("alert"));
        final List<DeviceDTO> deviceDTOList = new ArrayList<>();
        for(final Device dev : devices){
            deviceDTOList.add(modelMapper.map(dev,DeviceDTO.class));
        }
        return new ResponseEntity<>(deviceDTOList,HttpStatus.OK);
    }

    @Override
    public void changeStatusToAlert(final AlertDTO deviceId) {
        final Device device = deviceRepository.findOne(
                QDevice.device.deviceAddress.eq(deviceId.getDeviceId())
        ).orElseThrow(() -> new RuntimeException("Device Not Found"));
        device.setStatus("ALERT");
        deviceRepository.save(device);

    }
}
