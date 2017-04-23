
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teja
 */
public class abc {
    public static void main(String args[])
    {
    User user=new User();
 MongoClient  mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         DB db = mongoClient.getDB( "test" );
  String s= user.authenticate("uname", "password");
   DBCollection coll = db.getCollection("User");
       BasicDBObject andQuery = new BasicDBObject();
List <BasicDBObject> obj = new ArrayList<BasicDBObject>();
obj.add(new BasicDBObject("Username", "123"));
obj.add(new BasicDBObject("Password", "123"));
andQuery.put("$and", obj);
DBCursor cursor = coll.find(andQuery);
int i=0;
while (cursor.hasNext()) {
	System.out.println(cursor.next());
        i=1;
}
    System.out.println("abc"+i);
    
    }
    
    
}
