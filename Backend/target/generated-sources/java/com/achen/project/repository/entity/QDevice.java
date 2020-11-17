package com.achen.project.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDevice is a Querydsl query type for Device
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDevice extends EntityPathBase<Device> {

    private static final long serialVersionUID = 1549580254L;

    public static final QDevice device = new QDevice("device");

    public final StringPath deviceAddress = createString("deviceAddress");

    public final StringPath location = createString("location");

    public final StringPath status = createString("status");

    public final StringPath typeOfDevice = createString("typeOfDevice");

    public QDevice(String variable) {
        super(Device.class, forVariable(variable));
    }

    public QDevice(Path<? extends Device> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDevice(PathMetadata metadata) {
        super(Device.class, metadata);
    }

}

