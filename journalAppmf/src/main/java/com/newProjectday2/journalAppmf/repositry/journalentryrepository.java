package com.newProjectday2.journalAppmf.repositry;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Component;

import com.newProjectday2.journalAppmf.entity.journalentry;

@Component
public interface journalentryrepository extends MongoRepository <journalentry , ObjectId>{

    
}
