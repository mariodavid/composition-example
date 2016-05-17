create table COMPOSITIONEXAMPLE_COMPONENT (
    ID varchar(36) not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer not null,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(3),
    --
    NAME varchar(255),
    PARENT_ID varchar(36),
    --
    primary key (ID)
);
