package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service

public class DBService {

//    @Autowired
   private DB db;

    public DBService(DB db) {
        this.db = db;
    }

    public String getData(){
        return db.getData();
    }
}
