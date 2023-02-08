package qaautomation.december2022.task4APITestSignUp;

import java.io.File;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataUtilityTask4 {
	public static String dataFilePath = 
			System.getProperty("user.dir") + File.separator + "resources" + File.separator + "datasetSignUp.xlsx";
	
	public static String getDataFromExcel(String sheetName, String ID) {
		String result = "";
		
		try {
			Fillo fillo=new Fillo();
			Connection connection=fillo.getConnection(dataFilePath);
			String strQuery="Select * from "+ sheetName +" where ID='"+ID+"'";
			Recordset recordset=connection.executeQuery(strQuery);
			 
			while(recordset.next()){
			//System.out.println(recordset.getField("Value"));
				result = recordset.getField("value");
			}
			
			recordset.close();
			connection.close();
		} catch (FilloException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
