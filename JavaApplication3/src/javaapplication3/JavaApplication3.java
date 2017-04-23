/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author teja
 */   import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import java.util.Arrays;
public class JavaApplication3 {
    
 



   public static void main( String args[] ) {
	
      try{
		
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         DB db = mongoClient.getDB( "test" );
         System.out.println("Connect to database successfully");
        
			
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }
}

    /**
     * @param args the command line arguments
     */
   
    

