package io.csrohit.embedded.iot.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Project extends IdCaption {
    @OneToMany(mappedBy = "project")
    @JsonIgnore
    private List<MicroController> controllers;

    @ManyToOne
    @JsonIgnore
    private User user;
    public List<MicroController> getControllers() {
        return controllers;
    }

    public void setControllers(List<MicroController> controllers) {
        this.controllers = controllers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
