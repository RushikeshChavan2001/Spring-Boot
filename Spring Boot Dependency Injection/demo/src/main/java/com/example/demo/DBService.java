package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

//    @Autowired            ---> field DI
//    DB DBObj;

   // final DB db;
//   public  DBService(DB db){         //------->Mostly Used in Industry Constructor DI
//        this.db=db;                   //   ------>It promotes immutability, as dependencies can be declared as final.
//    }


    private DB db;                //---------> Setter Injection
    @Autowired                    //  ----------->   Dependencies are declared as private instance variables and corresponding setter methods are defined.
    public void setDBService(DB db){    //------->   Setter injection allows for optional dependencies and the ability to change dependencies at runtime.
       this.db=db;
    }



    String Display(){
     //   return DBObj.getData();
        return db.getData();
    }

}
