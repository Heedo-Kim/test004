package com.example.test004.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"type"}))
@EqualsAndHashCode
@NoArgsConstructor
public class Role {

    private static final long serialVersionUID = 3225934654367189648L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private Long id;

    @Getter
    private String type;

    @Column(columnDefinition = "varchar(30) not null comment 'role name'")
    @Getter
    private String roleName;

    @Column(columnDefinition = "varchar(50) not null comment '설명'")
    @Getter
    private String description;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP not null comment '생성일시'")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '갱신일시'")
    @Setter
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "varchar(25) null comment '갱신 주체자 id'")
    private String updatedBy;

}
