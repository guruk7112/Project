package Ecommerce.mycs.generic.FileUtility;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * @author Gurup
 */
public class JsonUtility {        //json syntax exception

	public int getDataFromJsonFile(String key) throws Exception  {

	JSONParser parser=new JSONParser();
	Object object=parser.parse(new FileReader("C:\\eclipse\\Mycs\\src\\main\\resources\\commondata.properties"));
	JSONObject jo=(JSONObject)object;
	 int data=(int) jo.get(key);
	 return data;
}
}
