package com.newProjectday2.journalAppmf.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/journal")
public class journalEntrycontrollerv2 {
  @Autowired
  private journalEntryService journalEntryService;

  @GetMapping
  public List<journalentry> getAll() {
    return journalEntryService.getAll();
  }

  @PostMapping
  public journalentry createEntry(@RequestBody journalentry myentry) {
    myentry.setDate(LocalDateTime.now());
    journalEntryService.saveEntry(myentry);
    return myentry;
  }

  @GetMapping("id/{myid}")
  public journalentry getjournalbyid(@PathVariable ObjectId myid) {
    return journalEntryService.findById(myid).orElse(null);
  }

  @DeleteMapping("id/{myid}")
  public boolean deletejournalbyid(@PathVariable ObjectId myid) {
     journalEntryService.deletById(myid);  
     return true;
  }

  @PutMapping("id/{id}")
  public journalentry updatejournal(@PathVariable ObjectId id, @RequestBody journalentry newEntry) {
    
   journalentry old = journalEntryService.findById(id).orElse(null);
   if (old != null){
      
    old.setTitle(newEntry.getTitle()!= null && !newEntry.getTitle().equals("") ? newEntry.getTitle():old.getTitle());

    old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());

   }


    journalEntryService.saveEntry(old);
    return old;
  }

}
