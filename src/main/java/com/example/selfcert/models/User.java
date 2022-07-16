package com.example.selfcert.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "`user`")
@Getter
@Setter
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String zone;
    @Transient
    private Date lastLoggedIn;
    @Transient
    private boolean recentlyActive;

}
