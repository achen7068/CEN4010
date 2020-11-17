package com.achen.project.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlert is a Querydsl query type for Alert
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlert extends EntityPathBase<Alert> {

    private static final long serialVersionUID = -1615159596L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlert alert = new QAlert("alert");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final QDevice deviceAddress;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath typeOfAlert = createString("typeOfAlert");

    public QAlert(String variable) {
        this(Alert.class, forVariable(variable), INITS);
    }

    public QAlert(Path<? extends Alert> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlert(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlert(PathMetadata metadata, PathInits inits) {
        this(Alert.class, metadata, inits);
    }

    public QAlert(Class<? extends Alert> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.deviceAddress = inits.isInitialized("deviceAddress") ? new QDevice(forProperty("deviceAddress")) : null;
    }

}

