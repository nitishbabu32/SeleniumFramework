package practice_package;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.societymanagement.genrics.JsonReader;


public class dataprovider{
@Test(dataProvider="getData")
public void useData(HashMap<String,String> input ){
	//System.out.println("First NAme "+fname +"MiddleName "+mname +"lastName " +lname);
	System.out.println(input.get("email")+ input.get("password")+ input.get("product"));
}

//@DataProvider
//public Object[][] setData() {
//	return new Object[][] {{"nitish","babu32","singh"},{"Ajit","kumar","singh"}};
//}


@DataProvider
public Object[][] getData() throws IOException
{
	JsonReader jr=new JsonReader();
	List<HashMap<String, String>> data = jr.getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\resources\\PurchaseOrder.json");
	return new Object[][]  {{data.get(0)}, {data.get(1) },{data.get(2) }};
	
}
}
