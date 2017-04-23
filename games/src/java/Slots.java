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
public class Slots {
    MongoClient mongoClient;
    DB db;
    Slots(){
        mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         db = mongoClient.getDB( "test" );
    }
    
    String GetSlots(){
        DBCollection coll = db.getCollection("Slots");
        DBCursor cursor = coll.find();
        String s=" ";
int i=0;
while (cursor.hasNext()) {
	System.out.println(cursor.next());
        i=1;
        s=s+"....."+cursor.next();
        
        
}
      return s;  
        
        
    }
    
    
    String UpdateSlots(String day,String slot){
        DBCollection coll = db.getCollection("Slots");
        BasicDBObject andQuery = new BasicDBObject();
        List <BasicDBObject> obj = new ArrayList<BasicDBObject>();
 DBObject oneDetails;
  BasicDBObject queryDetails = new BasicDBObject();
 queryDetails.put("day",day);
 DBCursor cursorDetails =coll.find(queryDetails);
 boolean Name=cursorDetails.hasNext();

      BasicDBObject newDocument =
	new BasicDBObject().append("$inc",
	new BasicDBObject().append(slot, -1));       
    coll.update(new BasicDBObject().append("day", day), newDocument);
   
  
    
    
    return GetSlots();
    }
    }
    
    
    

