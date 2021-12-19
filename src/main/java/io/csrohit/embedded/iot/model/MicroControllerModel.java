package io.csrohit.embedded.iot.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MicroControllerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Set<MicroController> getControllers() {
        return controllers;
    }

    public void setControllers(Set<MicroController> controllers) {
        this.controllers = controllers;
    }

    private String caption;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private Set<MicroController> controllers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
