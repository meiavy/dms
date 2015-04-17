package longtv.mapreduce;

import org.mongodb.morphia.MapreduceType;

import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;

import junit.framework.TestCase;
import longtv.dal.DataStore;
import longtv.dal.MongoDataStore;

public class LiveUVMapreduceTest extends TestCase {
	public void testGetLiveUv()
	{
		/*String map = "function() { "+ 
	             "var category; " +  
	             "if ( this.pages >= 250 ) "+  
	             "category = 'Big Books'; " +
	             "else " +
	             "category = 'Small Books'; "+  
	             "emit(category, {name: this.name});}";
	   
	   String reduce = "function(key, values) { " +
	                            "var sum = 0; " +
	                            "values.forEach(function(doc) { " +
	                            "sum += 1; "+
	                            "}); " +
	                            "return {books: sum};} ";
	   
	   MapReduceCommand cmd = new MapReduceCommand(books, map, reduce,
			     null, MapReduceCommand.OutputType.INLINE, null);

			   MapReduceOutput out = books.mapReduce(cmd);

			   for (DBObject o : out.results()) {
			    System.out.println(o.toString());
			   }
	   
	   */
	}
}
