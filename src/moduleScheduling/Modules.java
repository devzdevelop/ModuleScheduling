/* AOA Project
 * Name: Devin Brown
 * Title: AOA Project
 * Date: 11/28/2021
 * */
package moduleScheduling;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Modules {
	ArrayList<ArrayList<String>> modules = new ArrayList();
	ArrayList<String> moduleName = new ArrayList();
	ArrayList<String> moduleCode = new ArrayList();
	ArrayList<String> moduleCredit = new ArrayList();
	ArrayList<ArrayList<String>> prerequisites = new ArrayList();
	ArrayList<String> array = new ArrayList();
	String []nameArr = {"","","","","",""};
	int track2 = 0;
	String track;
	String newModuleName;
	String name;
	int count = 0;
	int count2 = 0;
	Scanner sc = new Scanner(System.in);
	Scanner scDelete = new Scanner(System.in);
	int [] trackPrerequisites = new int [6];
	HashMap<Integer, String> prerequisits = new HashMap<Integer, String>();
	
	public Modules(String track){
		modules.add(moduleName);
		modules.add(moduleCode);
		modules.add(moduleCredit);
		
		this.track = track;
	}
	

	public void modulesMenu() {
		System.out.println("\n\t\t\t\t" + track);
		System.out.println("\n\t\t\t\tModules");
		System.out.println("\t\t\t\t1. Add Module");
		System.out.println("\t\t\t\t2. Edit Module");
		System.out.println("\t\t\t\t3. Delete Module");
		System.out.println("\t\t\t\t4. View Existing Modules");
		System.out.println("\t\t\t\t5. View Ordered Modules");
		System.out.println("\t\t\t\t6. Previous Menu\n\n");
		moduleMenuOptions();
	}
	
	public void findModuleIndex(String [] nameArr, int localCount, ArrayList<String> prerequisitesFinder) {
		System.out.println("\n(From Options) Array list contains: ");
		for(int run = 0; run < localCount; run++) {
			for(int h = 0; h < nameArr.length; h++) {
					if(nameArr[h].equals(prerequisitesFinder.get(run))){
						 System.out.println("Found " + nameArr[h] + " at index: " + h);
					 }
			 }
		}
		System.out.print("local count: " + localCount);
	}
	
	public void moduleMenuOptions(){
		Scanner scMenuOtions = new Scanner(System.in);
		int input;
		
		try {
			System.out.print("Enter the option you want to edit from 1-5 or go back to previous menu by entering 6: ");
			input = scMenuOtions.nextInt();
		
			while(input != 1 || input != 2 || input != 3 || input != 4 || input != 5 || input !=6) {
				if(input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6) {
					switch(input) {
						case 1:
							addModules();
							break;
						
						case 2:
							editModules();
							break;
						
						case 3:
							deleteModules();
							break;
						
						case 4:
							displayModules();
							break;
	
						case 5:
							Graph g = new Graph(6);
							// adding all the modules to a key
							g.acceptPreReq(name, prerequisites, moduleName.size(), nameArr);
							int localCount = 0;
							String x;
	
							ArrayList<String> prerequisitesFinder = new ArrayList();
							
							for(int f = 0; f < track2; f++) {
									// iterate through the index prerequisites list to get each prerequisites per index
							 		Iterator<String> it = prerequisites.get(f).iterator();
							 		while (it.hasNext()) {
							 			x = it.next();
							 			prerequisitesFinder.add(x);
							 			localCount++;
									}
							 		
							 		// scan through the array that contains the added module then search for the index the prerequisite is located. Then add that index into addEdge along with name.
							 		for(int run = 0; run < localCount; run++) {
										for(int h = 0; h < nameArr.length; h++) {
												// adding the modules and their prerequisites to addEdge
												if(nameArr[h].equals(prerequisitesFinder.get(run))){
													g.addEdge(f, h);
												 }
										 }
									}
							 		prerequisitesFinder.clear();
							 		localCount = 0;
							 	
							 }
							
							 System.out.println("\nFollowing is a Topological "
							        + "sort of the given graph: ");
							 // Function Call
							     g.topologicalSort();
							break;
						
						case 6:
							MainMenu m = new MainMenu();
							m.menuDisplay();
							break;
						default:
							break;
					}
				}
				// display modules menu
				modulesMenu();
				System.out.print("\n\n");
				System.out.print("Enter the option you want to edit from 1-5 or go back to previous menu 6\n"
						+"by entering 5: ");
				input = scMenuOtions.nextInt();
				System.out.print("\n\n");
			}
		}catch (Exception e){
			System.out.println("Sorry, please enter a number from 1 - 6");
		}
		
		
		
	}
	
	public void addModules(){
		String code, credit, prereq;
		Scanner trackPrereq = new Scanner(System.in);
		
		
// ****  BELOW THIS LINE IS AUTOMATEED. SO UNCOMMENT HARD CODED SECTION AND COMMENT AUTOMATED SECTION TO ADD MANUALLY (HARD CODE ADD)  ****

	
		System.out.println("You can only add a maximum of 6 modules." + "The number of spaces available to add: " + (6-track2));
		
		try {
			System.out.println("\nEnter the name of a module you want to add: ");
			moduleName.add(sc.nextLine());
			//System.out.println(track2);
			name = moduleName.get(track2);
			nameArr[count2++] = name;
			
			System.out.println("\nEnter the name the module code: ");
			moduleCode.add(sc.nextLine());
			
			
			System.out.println("\nEnter the module credit: ");
			moduleCredit.add(sc.nextLine());
			
			modules.add(moduleName);
			modules.add(moduleCode);
			modules.add(moduleCredit);
		}catch(Exception e){
			System.out.println("Sorry, please enter words.");
		}
		
		
		System.out.print("\nIf you want to add any prerequisites then enter 1, else enter 0: ");
		System.out.println();
		
		try {
			trackPrerequisites[count] = trackPrereq.nextInt();
			do {
				if(trackPrerequisites[count] != 0 && trackPrerequisites[count] != 1) {
					System.out.println("You've entered the incorrect option. If you want to add any prerequisites then enter 1, else enter 0: ");
					trackPrerequisites[count] = trackPrereq.nextInt();
				}
				
			
			}while(trackPrerequisites[count] != 0 && trackPrerequisites[count] != 1);
		
			
			if(trackPrerequisites[count] == 1) {
				ArrayList<String> prerequisit = new ArrayList();
				System.out.println("\nEnter the prerequisite for this module: ");
				prerequisit.add(sc.nextLine());
				prerequisites.add(prerequisit);
			}
			else {
				ArrayList<String> prerequisit = new ArrayList();
				prerequisit.add(" ");
				prerequisit.add(" ");
				prerequisites.add(prerequisit);
			}
		}catch(Exception e){
			System.out.println("Sorry, please enter 1 or 0.");
			 System.exit(0);
		}
		
	
		
// ****   AUTOMATION STOPS HERE   ****
		
		
		
// ****  BELOW THIS LINE IS HARD CODED. SO COMMENT HARD CODED SECTION AND UNCOMMENT AUTOMATED SECTION TO ADD DYNAMICALLY  ****
/*

	
		//Module 1
		moduleName.add("Anaylsis of Algorithms");
		name = moduleName.get(track2);
		nameArr[count2++] = name;
		moduleCode.add("CIT3003");
		moduleCredit.add("3");
		modules.add(moduleName);
		modules.add(moduleCode);
		modules.add(moduleCredit);
		
		trackPrerequisites[count] = 1;
		
		if(trackPrerequisites[count] == 1) {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add("Advanced Programming");
			prerequisites.add(prerequisit);
		}
		else {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add(" ");
			prerequisit.add(" ");
			prerequisites.add(prerequisit);
		}
		track2++;
		count++;
		
		//Module 2
		moduleName.add("Data Structures");
		name = moduleName.get(track2);
		nameArr[count2++] = name;
		moduleCode.add("CMP2006");
		moduleCredit.add("4");
		modules.add(moduleName);
		modules.add(moduleCode);
		modules.add(moduleCredit);
		
		trackPrerequisites[count] = 1;
		
		if(trackPrerequisites[count] == 1) {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add("Anaylsis of Algorithms");
			prerequisites.add(prerequisit);
		}
		else {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add(" ");
			prerequisit.add(" ");
			prerequisites.add(prerequisit);
		}
		track2++;
		count++;
		
		//Module 3
		moduleName.add("Object Oriented Programming");
		name = moduleName.get(track2);
		nameArr[count2++] = name;
		moduleCode.add("CIT2004");
		moduleCredit.add("4");
		modules.add(moduleName);
		modules.add(moduleCode);
		modules.add(moduleCredit);
		
		trackPrerequisites[count] = 1;		
		if(trackPrerequisites[count] == 1) {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add("Data Structures");
			prerequisites.add(prerequisit);
		}
		else {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add(" ");
			prerequisit.add(" ");
			prerequisites.add(prerequisit);
		}
		track2++;
		count++;
		
		//Module 4
		
		moduleName.add("Discrete Mathematics");
		name = moduleName.get(track2);
		nameArr[count2++] = name;
		moduleCode.add("MAT1008");
		moduleCredit.add("4");
		modules.add(moduleName);
		modules.add(moduleCode);
		modules.add(moduleCredit);
		
		trackPrerequisites[count] = 1;
		
		if(trackPrerequisites[count] == 1) {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add("Anaylsis of Algorithms");
			prerequisites.add(prerequisit);
		}
		else {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add(" ");
			prerequisit.add(" ");
			prerequisites.add(prerequisit);
		}
		
	
		track2++;
		count++;
		
		//Module 5
		moduleName.add("College Mathematics 1B");
		name = moduleName.get(track2);
		nameArr[count2++] = name;
		moduleCode.add("MAT1047");
		moduleCredit.add("4");
		modules.add(moduleName);
		modules.add(moduleCode);
		modules.add(moduleCredit);
		
		trackPrerequisites[count] = 1;
		
		if(trackPrerequisites[count] == 1) {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add("Discrete Mathematics");
			prerequisites.add(prerequisit);
		}
		else {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add(" ");
			prerequisit.add(" ");
			prerequisites.add(prerequisit);
		}
		
		track2++;
		count++;
		
		//Module 6
		moduleName.add("Advanced Programming");
		name = moduleName.get(track2);
		nameArr[count2++] = name;
		moduleCode.add("CIT3003");
		moduleCredit.add("3");
		modules.add(moduleName);
		modules.add(moduleCode);
		modules.add(moduleCredit);
		
		trackPrerequisites[count] = 0;
		
		
		if(trackPrerequisites[count] == 1) {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add("");
			prerequisites.add(prerequisit);
		}
		else {
			ArrayList<String> prerequisit = new ArrayList();
			prerequisit.add(" ");
			prerequisit.add(" ");
			prerequisites.add(prerequisit);
		}
		
*/
	
// ****  HARD CODED PARTS END HERE ****
		
		track2++;
		count++;
	}
	
	public void editModules() {
		int input;
		int index, index2 = 0;
		String inputName, inputName2, newModuleCode, newModuleCredit, newModulePrerequisit;
		Scanner scEdit1 = new Scanner(System.in);
		Scanner scEdit2 = new Scanner(System.in);
		Scanner scEdit3 = new Scanner(System.in);
		Scanner scEdit4 = new Scanner(System.in);
		
		// display editing options
		editModuleMenu();
		// choose editing option
		System.out.print("Enter the option you want to edit from 1-5 or go back to previous menu with 6\n"
				+"by entering 5: ");
		input = sc.nextInt();
		System.out.print("\n\n");
		
		while(input != 1 || input != 2 || input != 3 || input != 4 || input != 5) {
			if(input == 1 || input == 2 || input == 3 || input == 4 || input == 5) {
				switch(input) {
				case 1:
					try {
						// display the module name after it being found
						displayModules();
						
						System.out.print("Enter the name of the module you want edit: ");
						inputName = scEdit1.nextLine();
						index = moduleName.indexOf(inputName);
						
						// display the module name after it being found
						displayModules();
						
						// enter new info
						System.out.print("Enter the new name for this module: ");
						newModuleName = scEdit1.nextLine();
						moduleName.set(index, newModuleName);
					}catch(IndexOutOfBoundsException f){
						System.out.println("Sorry, you entered the wrong name or the name doesn't exist.");
					}
					
					// updated module display
					displayModules();
					break;
				
				case 2:
					try {
						// display the module name after it being found
						displayModules();
						
						System.out.print("Enter the name of the module you want edit: ");
						inputName = scEdit2.nextLine();
						index = moduleName.indexOf(inputName);
						
						// display the module name after it being found
						displayModules();
						
						System.out.print("Enter the new module code for this module: ");
						newModuleCode = scEdit2.nextLine();
						moduleCode.set(index, newModuleCode);
						
						// updated module display
						displayModules();
					}catch(IndexOutOfBoundsException f){
						System.out.println("Sorry, you entered the wrong name or the name doesn't exist.");
					}	
					break;
				
				case 3:
					try {
						// display the module name after it being found
						displayModules();
						
						System.out.print("Enter the name of the module you want edit: ");
						inputName = scEdit3.nextLine();
						index = moduleName.indexOf(inputName);
						
						// display the module name after it being found
						displayModules();
						
						System.out.print("Enter the new credit score for the module: ");
						newModuleCredit = scEdit3.nextLine();
						moduleCredit.set(index, newModuleCredit);
						
						// updated module display
						displayModules();
					}catch(IndexOutOfBoundsException f){
						System.out.println("Sorry, you entered the wrong name or the name doesn't exist.");
					}
					break;
					
				case 4:
					try { 
						// display the module name after it being found
						displayModules();
						
						System.out.print("Enter the name of the module you want edit: "); 
						inputName = scEdit4.nextLine(); 
						index = moduleName.indexOf(inputName);
					  
						// display the module name after it being found
						displayModules();
					  
						System.out.println("Enter the name of the prerequisit you want to edit: ");
						inputName2 = scEdit4.nextLine(); 
						index2 = prerequisites.get(index).indexOf(inputName2);
					  
						System.out.print("Enter the new prerequisit for the module: ");
						newModulePrerequisit = scEdit4.nextLine(); 
						prerequisites.get(index).set(index2, newModulePrerequisit);
					}catch(IndexOutOfBoundsException f){
						System.out.println("Sorry, you entered the wrong name or the name doesn't exist.");
					}
					// updated module display
					displayModules();
				 
					break;
				
				case 5:
					modulesMenu();
					break;
				default:
					break;
				}	
			}
			else {
				// prints error message
				System.out.println("You've entered the incorrect choice. The choices are from 1-5 or 6 to go baack to previous menu."
						+ "\n Please try again.\n\n");
				
				// display editing menu
				editModuleMenu();
				System.out.print("\n\n");
				
				// re-enter option
				System.out.print("\nEnter the option you want to edit from 1-5 or go back to previous menu with 6 "
						+ "by entering 5: ");
				input = sc.nextInt();
				System.out.print("\n");
			}
			// display editing menu
			editModuleMenu();
			System.out.print("\n\n");
			System.out.print("Enter the option you want to edit from 1-5 or go back to previous menu with 6\n"
					+"by entering 5: ");
			input = sc.nextInt();
			System.out.print("\n\n");
		}
	}
	
	public void editModuleMenu() {
		System.out.println("\t\t\t\tEdit Module");
		System.out.println("\t\t\t\t 1. Module Name");
		System.out.println("\t\t\t\t 2. Module Code");
		System.out.println("\t\t\t\t 3. Module Credit");
		System.out.println("\t\t\t\t 4. Prerequisites");
		System.out.println("\t\t\t\t 5. Previous Menu\n");
	}
	
	public void deleteModules() {
		String input;
		int index;
		displayModules();
		try {
			System.out.print("\nEnter the name of the module you want to delete: ");
			input = scDelete.nextLine();
			index = moduleName.indexOf(input);
			moduleName.remove(index);
			moduleCode.remove(index);
			moduleCredit.remove(index);
			prerequisites.remove(index);
		}catch(IndexOutOfBoundsException f){
			System.out.println("Sorry, you entered the wrong name or the name doesn't exist.");
		}
	}
	
	public void displayModules() {
		int count = 0;
		for(int i = 0; i < this.moduleName.size(); i++) {
			System.out.println("\n\t\t\t\tModule: " + ++count);
			System.out.println("\t\t\t\tModule Name: " + moduleName.get(i));
			System.out.println("\t\t\t\tModule Code: " + moduleCode.get(i));
			System.out.println("\t\t\t\tCredit: " + moduleCredit.get(i));
			System.out.print("\t\t\t\tPrerequisites: ");
			for(int x = 0; x < prerequisites.get(i).size(); x++) {
				System.out.print(prerequisites.get(i).get(x));
				if(x < prerequisites.get(i).size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("\n\n");
		}
	}
	
	public void completeDeletion(int input) {
		int index;
		try {
			index = moduleName.indexOf(input);
			moduleName.remove(index);
			moduleCode.remove(index);
			moduleCredit.remove(index);
			prerequisites.remove(index);
		}catch(IndexOutOfBoundsException f){
			System.out.println("Sorry, you entered the wrong name or the name doesn't exist.");
		}
	}
	public static void main(String args[]) {
		Modules modules = new Modules("Testing");
		modules.modulesMenu();
	}
}
