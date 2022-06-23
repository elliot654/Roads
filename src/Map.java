/**
 * 
 * @author Elliot Sheehy 
 * @version 1.0 (25th February 2016)
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
public class Map {
	public ArrayList<Settlement> settlesAL = new ArrayList<Settlement>();
	public ArrayList<Road> roadAL = new ArrayList<Road>();
	public Map() {
		// INSERT CODE
	}

	/**
	 * In this version we display the result of calling toString on the command
	 * line. Future versions may display graphically
	 */
	public void display() {
		System.out.println(settlesAL.toString());
		System.out.println(roadAL.toString());
	}

	// STEPS 7-10: INSERT METHODS HERE, i.e. those similar to addSettlement and required
	// by the Application class
	
	public void load()  {
		// settlements
		try{
		Scanner infile = new Scanner(new FileReader("settlements.txt"));
		infile.useDelimiter("\r?\n|\r|:"); // Newlines on Unix or DOS
		int num = 0;
		for (int i = 0; i < num; i++) {
			String nm = infile.next();
			int pop = infile.nextInt();
			String k = infile.next();
			SettlementType result = null;
			for (SettlementType type: SettlementType.values()){
				System.out.print(type + " ");
			}
			result = SettlementType.valueOf(k);
			Settlement t = new Settlement(nm, result);
			t.setPopulation(pop);
			settlesAL.add(t);
		}
		infile.close();
	}
		catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file");                
        }
		
		//roads
		try{
			
		Scanner infile1 = new Scanner(new FileReader("roads.txt"));
		infile1.useDelimiter("\r?\n|\r|:"); // Newlines on Unix or DOS
		int num1 = 0;
		for (int i = 0; i < num1; i++) {
			String nm = infile1.next();		
			String k = infile1.next();
			double len = infile1.nextDouble();
			String s = infile1.next();		
			String d = infile1.next();
			Classification rResult = null;
			for (Classification cls: Classification.values()){
				System.out.print(cls + " ");
			}
			rResult = Classification.valueOf(k);	
			for (int i1 = 0;  i1 < settlesAL.size(); i1++)
				if(settlesAL.get(i1).getName().equalsIgnoreCase(s)){
					Settlement source = settlesAL.get(i1);
					//from string to settlement}
			for (int i11 = 0;  i11 < settlesAL.size(); i11++)
				if(settlesAL.get(i11).getName().equalsIgnoreCase(d)){
					Settlement destination = settlesAL.get(i11);
				
			Road t = new Road(nm, rResult, source, destination, len);
		}
				}
		}
		infile1.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file"); 
		}
	}
		
		
	public void save() {
	
		// STEP 6: INSERT CODE HERE
		try{
			BufferedWriter outStream= new BufferedWriter(new FileWriter("settlements.txt", true));
		//FileWriter writer = new FileWriter("settlements.txt"); 
		int size = settlesAL.size();
        for (int i=0;i<size;i++) {
            String str = settlesAL.get(i).toString();
            outStream.write(str);
            if(i < size-1)//This prevent creating a blank like at the end of the file**
            	outStream.write("\n");
        }
        outStream.close();
    
		
		FileWriter writer1 = new FileWriter("roads.txt"); 
		int size1 = roadAL.size();
        for (int i=0;i<size1;i++) {
            String str = roadAL.get(i).toString();
            writer1.write(str);
            if(i < size1-1)//This prevent creating a blank like at the end of the file**
                writer1.write("\n");
        }
        writer1.close();
    
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file");                  
        }
		    }
		
	

	public String toString() {
		String result = "";
		// INSERT CODE HERE
		return result;
	}
}
