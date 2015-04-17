package longtv.controller;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class MyMongoClient {
	private static MyMongoClient instance=new MyMongoClient();
	private MongoClient mongoClient;
	public static MongoClient getInstance()
	{
		if(instance==null)
		{
			instance=new MyMongoClient();
		}
		return instance.mongoClient;
	}
	
	private MyMongoClient()
	{
		mongoClient = new MongoClient(new ServerAddress("127.0.0.1", 27017));		
	}
}
