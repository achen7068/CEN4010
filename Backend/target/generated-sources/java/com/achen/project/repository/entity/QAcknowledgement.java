package com.achen.project.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAcknowledgement is a Querydsl query type for Acknowledgement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAcknowledgement extends EntityPathBase<Acknowledgement> {

    private static final long serialVersionUID = 1212606834L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAcknowledgement acknowledgement = new QAcknowledgement("acknowledgement");

    public final QAlert alert;

    public final StringPath id = createString("id");

    public final DatePath<java.time.LocalDate> localDate = createDate("localDate", java.time.LocalDate.class);

    public QAcknowledgement(String variable) {
        this(Acknowledgement.class, forVariable(variable), INITS);
    }

    public QAcknowledgement(Path<? extends Acknowledgement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAcknowledgement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAcknowledgement(PathMetadata metadata, PathInits inits) {
        this(Acknowledgement.class, metadata, inits);
    }

    public QAcknowledgement(Class<? extends Acknowledgement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.alert = inits.isInitialized("alert") ? new QAlert(forProperty("alert"), inits.get("alert")) : null;
    }

}

