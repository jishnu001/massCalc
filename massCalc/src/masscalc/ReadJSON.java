/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masscalc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author jishnu
 */
public class ReadJSON {
    
    
   public static void getData(JSONObject obj,String name)
   {
     JSONObject structure = obj.getJSONObject(name);
                System.out.println("Atomic: " + structure.get("atomic"));
                System.out.println("Mass: " + structure.get("mass"));
              
   
   }
    
    public  void ReadJSONValues() throws FileNotFoundException, JSONException {
       
         String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("periodictable.json"));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
              

		//System.out.println("File Content: \n" + jsonData);
		JSONObject obj = new JSONObject(jsonData);
                 Scanner scan = new Scanner(System.in);
                String s = scan.next();
                   getData(obj,s);
    
    }
    
}
