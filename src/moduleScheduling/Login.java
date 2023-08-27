/* AOA Project
 * Name: Devin Brown
 * Title: AOA Project
 * Date: 11/28/2021
 * */
package moduleScheduling;
import java.util.*;


public class Login {
	private String username;
	private String password; 
	Scanner sc = new Scanner(System.in);
	MainMenu mainMenu = new MainMenu();
	
	public String getUsername () {
		return username;
	}
	
	public void setUsername (String username) {
		
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword (String password) {
		
	}
	
	void promptLoginInfo() {
		int atempts = 0;
		System.out.println("\t\t\t\t---------------------");
		System.out.println("\t\t\t\t+ Welcome To VINLOX +");
		System.out.println("\t\t\t\t---------------------\n");

		try {
			  Thread.sleep(1000);//time is in ms (1000 ms = 1 second)
			} catch (InterruptedException e) {e.printStackTrace();}
		
		//Accept login info and do a validation check on the info that was accepted.
		do {
			if(atempts < 3) {
				System.out.print("\n\t\t\t\tEnter Userame: ");
				this.username = sc.nextLine();
				System.out.println(); // add space
				System.out.print("\t\t\t\tEnter Password: ");
				this.password = sc.nextLine();
				
				try {
					  Thread.sleep(1000); //time is in ms (1000 ms = 1 second)
					} catch (InterruptedException e) {e.printStackTrace();}
				
				// if the correct information entered was valid and prints message based on the results
				if(this.username.equals("Admin") && this.password.equals("Root")){
					System.out.println("\n\n\t\t\t     Login Successfully, Good Day!");
					//pause for 1.5 second
					try {
						  Thread.sleep(1500);//time is in ms (1000 ms = 1 second)
						} catch (InterruptedException e) {e.printStackTrace();}
					
					// prints Main Menu

					for (int i = 0; i < 50; ++i) System.out.println();
					mainMenu.menuDisplay();
				}
				else {
					System.out.println("\n\n\t\tThe information you've entered is incorrect. Try again.");
				}
				atempts++;
				System.out.println("\n\t\tYou have " + (3-atempts) + " attempts left.\n\n\n");
			}else {
				System.out.println("\t\tYou've exceeded the maxium attempts.");
				break;
			}
		}while(!this.username.equals("Admin") || !this.password.equals("Root"));
	}

}
