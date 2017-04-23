/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teja
 */
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Credits {
      MongoClient mongoClient;
    DB db;
    Credits(){
        mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         db = mongoClient.getDB( "test" );
    }
 String  SetCredits(String name,int credits){
     
        DBCollection coll = db.getCollection("User");
      BasicDBObject newDocument =
	new BasicDBObject().append("$inc",
	new BasicDBObject().append("Credits", credits));       
    coll.update(new BasicDBObject().append("Username", name), newDocument);
     
     DBObject db=coll.findOne(new BasicDBObject().append("Username",name));
     String s=db.toString();
     String[] a=s.split(",");
     try{
     
     String b= a[a.length-1];
     String []c=b.split(":");
     System.out.println(c[1]);
     return c[1];
     }
     catch(Exception e)
     {
         return "0";
     }
     
     }
     
        
    }
    

