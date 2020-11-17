package com.achen.project.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeviceDTO {

    @NotNull
    String deviceAddress;
    @NotNull
    String location;
    @NotNull
    String typeOfDevice;
    @NotNull
    String status;

}
