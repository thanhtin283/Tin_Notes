package com.thanhtin.inotes.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "note_type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Type.class)
    private List<Type> types;

    public Type(){
    }

    public Type(String name){
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}
