package io.csrohit.embedded.iot.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MicroControllerModel extends IdCaption {





    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private Set<MicroController> controllers;

    public Set<MicroController> getControllers() {
        return controllers;
    }

    public void setControllers(Set<MicroController> controllers) {
        this.controllers = controllers;
    }

}
