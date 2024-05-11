package com.newProjectday2.journalAppmf.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newProjectday2.journalAppmf.entity.journalentry;
import com.newProjectday2.journalAppmf.service.journalEntryService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/journal")
public class journalEntrycontrollerv2 {
  @Autowired
  private journalEntryService journalEntryService;

  @GetMapping
  public ResponseEntity<?> getAll() {
    List <journalentry> all = journalEntryService.getAll();
    if(all != null && !all.isEmpty() ){
      return new ResponseEntity<>(all , HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  @PostMapping
  public ResponseEntity<journalentry> createEntry(@RequestBody journalentry myentry) {
    try
    {
    myentry.setDate(LocalDateTime.now());
    journalEntryService.saveEntry(myentry);
    return new ResponseEntity<>(myentry ,HttpStatus.CREATED);
  } catch(Exception e){
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
  }

  @GetMapping("id/{myid}")
  public ResponseEntity<journalentry> getjournalbyid(@PathVariable ObjectId myid) {
   Optional<journalentry> journalEntry = journalEntryService.findById(myid);
   if(journalEntry.isPresent()){
    return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
   }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("id/{myid}")
  public ResponseEntity<?>deletejournalbyid(@PathVariable ObjectId myid) {
     journalEntryService.deletById(myid);  
     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("id/{id}")
  public ResponseEntity <journalentry> updatejournalById(@PathVariable ObjectId id, @RequestBody journalentry newEntry) {
    
   journalentry old = journalEntryService.findById(id).orElse(null);
   if (old != null){
      
    old.setTitle(newEntry.getTitle()!= null && !newEntry.getTitle().equals("") ? newEntry.getTitle():old.getTitle());

    old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
    journalEntryService.saveEntry(old);
    return new ResponseEntity<>(old , HttpStatus.OK);

   }
   return new ResponseEntity<>( HttpStatus.NOT_FOUND);
  }

}
