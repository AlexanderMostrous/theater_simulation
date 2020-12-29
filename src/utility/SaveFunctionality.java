package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entities.Play;

public abstract class SaveFunctionality {

	
	/*public SaveFunctionality()
	{
		
	}*/	
	
	public static void save()
	{
        String filename = "HCI_data.ser"; 
        ArrayList<Play> list = DataHolder.plays;
          
        // Serialization  
        try
        {
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(list); 
              
            out.close(); 
            file.close();   
        }        
        catch(IOException ex) 
        { 
            ex.printStackTrace();
        } 
	}
	
	public static void load()
	{
		String filename = "HCI_data.ser"; 
		ArrayList<Play> list;
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            list = (ArrayList<Play>)in.readObject(); 
              
            in.close(); 
            file.close();  
            DataHolder.plays = list;
        }          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		
		
	}
}
