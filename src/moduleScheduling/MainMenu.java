/* AOA Project
 * Name: Devin Brown
 * Title: AOA Project
 * Date: 11/28/2021
 * */
package moduleScheduling;
import java.util.*;
public class MainMenu {
	public int mainMenuInput = 0; 
	Program program = new  Program();
	
	Scanner sc = new Scanner(System.in);
	
	MainMenu(){
		
	}
	
	public void menuDisplay() {
		try {
			do {
				System.out.println("\t\t\t\t----------------------------");
				System.out.println("\t\t\t\t+ 1. SELECT YOUR PROGRAM + \n" +
								"\t\t\t\t+ 2. ADD PROGRAM         +\n" +
								"\t\t\t\t+ 3. RENAME PROGRAM      +\n" +
								"\t\t\t\t+ 4. DELETE PROGRAM      +\n" +
								"\t\t\t\t+ 5. VIEW PROGRAMS       +\n" +
								"\t\t\t\t+ 6. EXIT                  +");
			   System.out.println("\t\t\t\t----------------------------");
		
				for (int i = 0; i < 3; ++i) System.out.println();
				System.out.print("\t\t\t\tEnter your option from (1-6): ");
				this.mainMenuInput = sc.nextInt();
				
				switch(this.mainMenuInput) {
					case 1:
						program.selectProgram();
						menuDisplay();
						break;
					case 2:
						program.addProgram();
						menuDisplay();
						break;
					case 3:
						program.editPrograms();
						menuDisplay();
						break;
					case 4:
						program.deletePrograms();
						menuDisplay();
						break;
					case 5:
						program.viewPrograms();
						menuDisplay();
						break;
					case 6:
						System.out.println("\nGood Bye :)");
						System.exit(0);
						break;
					default:
						System.out.println("Incorrection option slected. Select an option from (1-4) based on the menu above\n");
						break;
				}
			}while(this.mainMenuInput != 1 ||this.mainMenuInput != 2 || this.mainMenuInput != 3 || this.mainMenuInput != 4 || this.mainMenuInput != 5 || this.mainMenuInput != 6);
		}
		catch (InputMismatchException e){
			System.out.println("Sorry, please enter a number, the correct program or add a program before selecting.");
		}
		catch(IndexOutOfBoundsException f){
			System.out.println("Sorry, you entered the wrong name or the name doesn't exist.");
		}
		
	}
	public static void main(String args[]) {
		
	}
}
