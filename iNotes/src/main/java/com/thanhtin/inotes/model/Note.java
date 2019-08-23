package com.thanhtin.inotes.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    @Column(updatable = false)
    @CreationTimestamp
    private Date dateCreate;


    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public Note(){

    }
    public Note(String title,String content,Date dateCreate){
        this.title=title;
        this.content=content;
        this.dateCreate=dateCreate;
    }
    @Override
    public String toString(){
        return String.format("Note[id=%d,title='%s',content='%s']",id,title,content);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
