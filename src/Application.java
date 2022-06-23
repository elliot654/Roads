

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.*;


/**
 * Main class to test the Road and Settlement classes
 * 
 * @author Elliot Sheehy (add your name and change version number/date)
 * @version 1.0 (24th February 2016)
 *
 */
public class Application {
	

	private Scanner scan;
	private Map map;
	
	public Application() {
		scan = new Scanner(System.in);
		map = new Map();
	}

	private void runMenu() {
		String option;
		do {
			System.out.println("choose");
			System.out.println("a: create settlement");
			System.out.println("b: delete settlement");
			System.out.println("c: create road");
			System.out.println("d: delete road");
			System.out.println("e: display map");
			System.out.println("f: save");
			System.out.println("g: quit");
			option = scan.next();
			switch (option) {
			case "a": 
				newSettlement();
				break;
			case "b": 
				deleteSettlement();
				break;
			case "c": 
				newRoad();
				break;
			case "d": 
				deleteRoad();
				break;
			case "e": 
				map.display();
				break;
			case "f":
				save();
				break;
			case "g": 
				System.out.println("quitting");
				break;
			default:
				System.out.println("try again");
			}
			
		}while(!option.equals("g"));		
	}

	// STEP 1: ADD PRIVATE UTILITY MENTHODS HERE. askForRoadClassifier, save and load provided
	// do stuff here
	
	public void newSettlement() {
		System.out.print("Enter new settlement name ");
		String newName = scan.next();	
		SettlementType newType = askForSettlementClassifier();	
		System.out.print("Enter population ");
		int newPop=scan.nextInt(); //get inputs
		Settlement var = new Settlement(newName, newType); //constructor
		var.setPopulation(newPop);
		map.settlesAL.add(var);//add to array list
		}
	
	public void newRoad(){
		System.out.print("Enter new road name ");
		String newRoad=scan.next(); 
		System.out.print("Enter new settlement type ");
		Classification classification=askForRoadClassifier();
		System.out.print("Enter road length ");
		double length= scan.nextDouble();
		System.out.print("Enter source settlement ");
		String s =scan.next(); //get inputs
		for (int i = 0;  i < map.settlesAL.size(); i++)
			if(map.settlesAL.get(i).getName().equalsIgnoreCase(s)){
				Settlement source = map.settlesAL.get(i);//from string to settlement
			
		System.out.print("Enter destination settlement ");
		String d =scan.next();
		for (int i1 = 0;  i1 < map.settlesAL.size(); i1++)
			if(map.settlesAL.get(i1).getName().equalsIgnoreCase(d)){
				Settlement destination = map.settlesAL.get(i1);
			
				Road var2 = new Road(newRoad, classification, source, destination, length);//constructor
				map.roadAL.add(var2);//add to array list
	}
			}
	}
	
	
	public void deleteSettlement(){
		System.out.print("Enter settlement name ");
		String oldName = scan.next();	//get inputs
		
		for (int i = 0;  i < map.settlesAL.size(); i++)
				if(map.settlesAL.get(i).getName().equalsIgnoreCase(oldName)){//find arraylist element that matches input
				map.settlesAL.remove(i);//get rid of it
				}
			}		 
	
	
	public void deleteRoad(){
		System.out.print("Enter road name ");
		String oldName = scan.next();
		for (int i = 0;  i < map.settlesAL.size(); i++)
			if(map.roadAL.get(i).getName().equalsIgnoreCase(oldName)){
			map.roadAL.remove(i);
			}
		
	}
	
	public Classification askForRoadClassifier() {//gets classification 
		Classification result = null;
		boolean valid;
		do{
			valid = false;
			System.out.print("Enter a road classification: ");
			for (Classification cls: Classification.values()){
				System.out.print(cls + " ");
			}
			String choice = scan.nextLine().toUpperCase();
			try {
				result = Classification.valueOf(choice);
				valid = true;
			} catch (IllegalArgumentException iae){
				System.out.println(choice + " is not one of the options. Try again.");
			}
		}while(!valid);
		return result;
	}
	
	public SettlementType askForSettlementClassifier() {//gets type
		SettlementType result = null;
		boolean valid;
		do{
			valid = false;
			System.out.print("Enter a settlement classification: ");
			for (SettlementType type: SettlementType.values()){
				System.out.print(type + " ");
			}
			String choice = scan.nextLine().toUpperCase();
			try {
				result = SettlementType.valueOf(choice);
				valid = true;
			} catch (IllegalArgumentException iae){
				System.out.println(choice + " is not one of the options. Try again.");
			}
		}while(!valid);
		return result;
	}
	
	private void save() {
		map.save();
	}

	private void load() {
		map.load();
	}

	private void printMenu() {
		// STEP 1: ADD CODE HERE
	}

	public static void main(String args[]) {
		Application app = new Application();//loads at start automatically
		app.load();
		app.runMenu();
		app.save();//saves at end automatically
	}

}

