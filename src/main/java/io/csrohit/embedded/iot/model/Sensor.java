package io.csrohit.embedded.iot.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
public class Sensor extends IdCaption {


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
