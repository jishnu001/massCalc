/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masscalc;

import java.util.Scanner;


/**
 *
 * @author jishnu
 */
public class MassCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ReadJSON readjson = new ReadJSON();
        try{
        readjson.ReadJSONValues();
        }
        catch(Exception ex)
        {
        System.out.println("Error");
        }
        
        
    }
    
}
