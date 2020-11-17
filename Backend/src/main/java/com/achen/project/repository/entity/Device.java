package com.achen.project.repository.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@Table(name = "devices")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Device {
    public Device(){

    }
    @Id
    String deviceAddress;

    String location;

    String typeOfDevice;

    String status;

}
