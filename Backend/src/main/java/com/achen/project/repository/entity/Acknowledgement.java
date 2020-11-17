package com.achen.project.repository.entity;

import com.achen.project.security.repository.entity.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "acknowledgements")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Acknowledgement {
    @Id
    String id = UUID.randomUUID().toString().replace("-", "");

    @OneToOne
    Alert alert;

    LocalDate localDate;

}
