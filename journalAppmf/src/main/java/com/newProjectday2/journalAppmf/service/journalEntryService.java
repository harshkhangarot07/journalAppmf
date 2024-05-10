package com.newProjectday2.journalAppmf.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newProjectday2.journalAppmf.entity.journalentry;
import com.newProjectday2.journalAppmf.repositry.journalentryrepository;
@Component
public class journalEntryService {


    @Autowired
    private journalentryrepository journalentryrepository;

    public void saveEntry(journalentry journalentry){
        journalentryrepository.save(journalentry);
    }

    public List<journalentry> getAll(){
        return journalentryrepository.findAll();
    }

    public Optional<journalentry> findById(ObjectId id){
        return journalentryrepository.findById(id);
    }
    
    public void deletById(ObjectId id){
         journalentryrepository.deleteById(id);
    }

}
