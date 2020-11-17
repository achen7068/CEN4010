package com.achen.project.repository.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "alerts")
public class Alert {
    @Id
    @Column(name = "alert_id")
    Integer id;

    @OneToOne
    Device deviceAddress;

    @Column(name = "type_of_alert")
    String typeOfAlert;

    @Column(name = "date_of_alert")
    Date date;

}
