package io.csrohit.embedded.iot.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class MicroController extends IdCaption {


    @ManyToOne
    @JoinColumn(name = "type_id")
    private MicroControllerModel type;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "controller")
    @JsonIgnore
    List<Sensor> sensors;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public MicroControllerModel getType() {
        return type;
    }

    public void setType(MicroControllerModel type) {
        this.type = type;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }


}
