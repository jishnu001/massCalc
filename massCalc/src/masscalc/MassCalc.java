/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masscalc;

import java.util.Scanner;
import org.json.JSONObject;
import java.text.DecimalFormat;
import java.lang.Math;

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
        getUserInput(args,com);
        getWeights(com);
        CalcMass.Calculate(com);
        DecimalFormat form = new DecimalFormat("0.00");
        for(int i=0;i<com.getNoElements();i++)
        {
          System.out.println("Weight of the element "+ com.getElement()[i].getName() +" in "+ com.getWeight() + " grams of the compound is: ");
          System.out.println(form.format(  com.getElement()[i].getCalcElWeight()) + " grams ");
          System.out.print("(" + String.format("%6.3e",  com.getElement()[i].getNewNoAtoms() )+ " atoms) ");
          System.out.printf("( %.3f moles) \n", com.getElement()[i].getNewNoMoles());
        }
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


    public static void getUserInput(String [] args,Compound com)
    {

        if(args.length<5)
        {
            System.out.println("Wrong number of arguments;");
            System.out.print("Usage : <no of elem in compund> <ele1 symbol> <no of ele1 atoms> <ele2 symbol> <no of ele2 atoms> ...");
            System.out.print(" <weight of the compound in grams> ");

        }
        //System.out.println("Enter the number of elements present in the compound: ");
        //Scanner scan = new Scanner(System.in);
        com.setNoElements(Integer.parseInt(args[0]));
        Element[] ell = new Element[com.getNoElements()];
        int j=1;
        for(int i=0;i<com.getNoElements();i++)
        {
            ell[i] = new Element();
           // System.out.println("Enter the symbol of the first element in the compound: ");
            ell[i].setName(args [j]);
            j++;
            //System.out.println("How many "+ ell[i].getName()+" atoms are present in the compound: ");
            ell[i].setNumber(Integer.parseInt(args[j]));
            j++;

        }
        com.setElement(ell);
       // System.out.println("Enter the weight of the compound in grams: ");
        com.setWeight(Float.parseFloat(args[j]));
    }


}
