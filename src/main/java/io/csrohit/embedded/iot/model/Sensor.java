package io.csrohit.embedded.iot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
public class Sensor {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String caption;

    private String description;

    @ManyToOne
    @JoinColumn(name = "controller_id")
    private MicroController controller;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTimeStamp;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimeStamp;


    @PrePersist
    public void setCreateTimeStamp(){
        createTimeStamp = updateTimeStamp = Date.from(Instant.now());
    }

    @PreUpdate
    public void setUpdateTimeStamp(){
        updateTimeStamp = Date.from(Instant.now());
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setController(MicroController controller) {
        this.controller = controller;
    }

    public MicroController getController() {
        return controller;
    }

}
