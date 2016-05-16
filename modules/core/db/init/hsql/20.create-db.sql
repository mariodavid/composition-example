-- begin COMPOSITIONEXAMPLE_COMPONENT
alter table COMPOSITIONEXAMPLE_COMPONENT add constraint FK_COMPOSITIONEXAMPLE_COMPONENT_PARENT_ID foreign key (PARENT_ID) references COMPOSITIONEXAMPLE_COMPONENT(ID)^
create index IDX_COMPOSITIONEXAMPLE_COMPONENT_PARENT on COMPOSITIONEXAMPLE_COMPONENT (PARENT_ID)^
-- end COMPOSITIONEXAMPLE_COMPONENT