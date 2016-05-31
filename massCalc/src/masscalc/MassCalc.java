/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masscalc;

import java.util.Scanner;
import org.json.JSONObject;

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
        Compound com = new Compound();
        getUserInput(com);
        getWeights(com);
        CalcMass.Calculate(com);
        }
        catch(Exception ex)
        {
        System.out.println("Error "+ ex.toString());
        }
        
        
    }
    
    public static void getWeights(Compound com)
    {
        try{

            JSONObject obj = ReadJSON.ReadJSONValues();
            for(int i=0;i<com.getNoElements();i++)
            {
                JSONObject structure = obj.getJSONObject(com.getElement()[i].getName());
               // System.out.println("Atomic: " + structure.get("atomic"));
               // System.out.println("Mass: " + structure.get("mass"));
               com.getElement()[i].setMolarWeight(Float.parseFloat(structure.get("mass").toString()));
               //System.out.println(com.getElement()[i].getMolarWeight());
               com.setComMolarWeight();
            }
            
        }
        catch(Exception ex)
        {
        System.out.println("Error "+ ex.toString());
        }
    
    
    }
    
    
    public static void getUserInput(Compound com)
    {
    
        System.out.println("Enter the number of elements present in the compound: ");
        Scanner scan = new Scanner(System.in);
        com.setNoElements(scan.nextInt());
        Element[] ell = new Element[com.getNoElements()];
        for(int i=0;i<com.getNoElements();i++)
        {
            ell[i] = new Element();
            System.out.println("Enter the symbol of the first element in the compound: ");
            ell[i].setName(scan.next());
            System.out.println("How many "+ ell[i].getName()+" atoms are present in the compound: ");
            ell[i].setNumber(scan.nextInt());
            
            
        }
        com.setElement(ell);
        System.out.println("Enter the weight of the compound in grams: ");
        com.setWeight(scan.nextFloat());
    }
    
    
}
