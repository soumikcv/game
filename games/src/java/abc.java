
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
 Credits c=new Credits();
 String s=c.SetCredits("123", 2);
   System.out.println(s);
    
    
}
}
