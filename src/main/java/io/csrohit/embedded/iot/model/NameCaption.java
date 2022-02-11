package io.csrohit.embedded.iot.model;

import javax.persistence.*;

@MappedSuperclass
public class NameCaption {

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String caption;

    public NameCaption(String name, String caption) {
        this.name = name;
        this.caption = caption;
    }

    public NameCaption() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
