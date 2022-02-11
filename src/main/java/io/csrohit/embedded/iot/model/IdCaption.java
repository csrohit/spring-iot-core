package io.csrohit.embedded.iot.model;

import javax.persistence.*;

@MappedSuperclass
public class IdCaption {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String caption;

    public IdCaption(long id){
        this.id = id;
    }

    public IdCaption(){

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

}
