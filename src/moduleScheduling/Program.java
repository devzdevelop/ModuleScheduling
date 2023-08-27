/* AOA Project
 * Name: Devin Brown
 * Title: AOA Project
 * Date: 11/28/2021
 * */
package moduleScheduling;
import java.util.*;
public class Program {
	ArrayList<String> programDispay = new ArrayList();
	ArrayList<String> programDisplayInput = new ArrayList();
	ArrayList<String> programName = new ArrayList();
	ArrayList<ArrayList<String>> programs = new ArrayList();
	Scanner sc = new Scanner(System.in);	
	public String track;
	int count = 0;


	
	Program(){
		programs.add(programName);
	}
	
	public void selectProgram() {
		Scanner sc = new Scanner(System.in);
		int input;
		
		viewPrograms();
		try {
			System.out.println("Select one of the options: ");
			input = sc.nextInt();
			
			System.out.println();
			do {
				if(input <= programName.size()) {
					this.track  = programName.get(input-1);
					Modules modules = new Modules(this.track);
					modules.modulesMenu();
				} 
				else {
					System.out.println("You've entered an incorrect value or the program you are selecting doesn't exist. Add a program to continue.");
					break;
				}
			}while(input != programName.size());
		}catch(IndexOutOfBoundsException f){
			System.out.println("Sorry, you entered the incorrect option.  or the program you are selecting doesn't exist. Add a program to continue.");
		}
			
	}
	
	public void addProgram() {
		Scanner sc = new Scanner(System.in);
		if(count<3) {
			
			count++;
		}else {
			System.out.println("You can't add anymore programs, the maxium number of programs you \ncan add is 3\n");
		}
		System.out.println("Enter the name of the program you want to add: ");
		programName.add(sc.nextLine());
		viewPrograms();
	}
	
	public void editPrograms() { // IMPORTANT ADD AN OUT OF BOUND EXCEPTION (java.lang.IndexOutOfBoundsException)
		Scanner sc = new Scanner(System.in);
		int index;
		String newName;
		
		try {
			// enter the name of the program you want to find and locate it.
			System.out.println("Enter the name of the program you want to change: ");
			// find the index
			index = programName.indexOf(sc.nextLine());
			
			// collect the new name of the program
			System.out.println("Enter the new name for this program: ");
			newName = sc.nextLine();
			// change the program name
			programName.set(index, newName);
		}catch(IndexOutOfBoundsException f){
			System.out.println("Sorry, you entered the wrong name or the name doesn't exist.");
		}
		
		viewPrograms();
	}
	
	
	public void deletePrograms() {
		Modules modules2 = new Modules(this.track);
		Scanner sc = new Scanner(System.in); 
		int index;
		try {
		// enter the name of the program you want to find and locate it.
			System.out.println("Enter the name of the program you want to delete: ");
			// find the index
			index = programName.indexOf(sc.nextLine());
			programName.remove(index);
			viewPrograms();
			modules2.completeDeletion(index);
		}catch(IndexOutOfBoundsException f){
			System.out.println("Sorry, you entered the wrong name or the name doesn't exist.");
		}
	}
	
	
	public void viewPrograms() {
		int count = 1;
		try{
			System.out.println("\n\t\t\tProrams");
			for(int i = 0; i < programName.size(); i++) {
				System.out.println("\t\t\t"+ count++ + ". "  + programName.get(i));
			}
			System.out.println("\n\n");
		}catch(Exception e) {
			System.out.println("Sorry, you are trying to access an index that is not there.");
		}
	}

	public static void main(String args[]) {
		
	}
}
