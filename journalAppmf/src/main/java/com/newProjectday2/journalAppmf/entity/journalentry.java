package com.newProjectday2.journalAppmf.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.ObjectError;

@Document(collection =  "jpurnal_entries")
public class journalentry {
    @Id
    private ObjectId id;


    public void setId(ObjectId id) {
        this.id = id;
    }

    public journalentry(ObjectId id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
   private LocalDateTime date;
   
    public ObjectId getId() {
        return id;
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

    private String title;
     
    private String content;


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setTitle(journalentry newEntry) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }

}
