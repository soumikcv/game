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
public class User {
    MongoClient mongoClient;
    DB db;
    String username;
    
    
    User()
    {  mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         db = mongoClient.getDB( "test" );
    }
    
    
    
    public  String createuser( String username,String  password ) {
           try{   
		
         System.out.println("Connect to database successfully");
			
         //boolean auth = db.authenticate(myUserName, myPassword);
         //System.out.println("Authentication: "+auth);
			DBObject person = new BasicDBObject("Username",username ) .append("Password",password).append("Credits",0);
                                                        
         DBCollection coll = db.getCollection("User");
         coll.insert(person);
         System.out.println("Collection created successfully");
         return("User Created");
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         
         
                return "error";
                 }
                 
      }
	
    String authenticate(String uname,String password){
        DBCollection coll = db.getCollection("User");
       BasicDBObject andQuery = new BasicDBObject();
List <BasicDBObject> obj = new ArrayList<BasicDBObject>();
obj.add(new BasicDBObject("Username", uname));
obj.add(new BasicDBObject("Password", password));
andQuery.put("$and", obj);
DBCursor cursor = coll.find(andQuery);
int i=0;
while (cursor.hasNext()) {
	System.out.println(cursor.next());
        i=1;
        
}
if(i==1)
{
i++;
return "authenticated";
}
else 
{
    return "invalid user";
   
}
    
    
    }
}
    

