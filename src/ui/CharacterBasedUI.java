/**
 * 
 */
package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import client.Client;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class CharacterBasedUI {

	public int menu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int reply = 0;
		System.out.println("Hello, welcome to configuration panel");
		System.out
				.println("Please enter the numbers by the following commands to perform the needed functions. Thank you.");
		System.out.println("1. Upload a Properties file.");
		System.out.println("2. Show the available Pizzerias.");
		System.out.println("3. Print a Pizzeria.");
		System.out.println("4. Delete a Pizzeria.");
		System.out.println("5. Configure a Pizzeria.");
		System.out.println("-1. Exit.");

		try {
			reply = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Wrong input. Numbers only please");
		}

		return reply;

	}
	
	public int configmenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int reply = 0;
		System.out.println("Ready to configure a pizzeria.");
		System.out
				.println("Please enter the numbers by the following commands to perform the needed functions. Thank you.");
		System.out.println("1. Update baseprice.");
		System.out.println("2. Add option to an optionset.");
		
		System.out.println("99. Go back.");

		try {
			reply = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Wrong input. Numbers only please");
		}

		return reply;

	}
	
	public int configoptions() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int reply = 0;
		System.out.println("Enter the optionset and options ");
		System.out
				.println("Please enter the numbers by the following commands to perform the needed functions. Thank you.");
		System.out.println("1. Update baseprice.");
		System.out.println("2. Add option to an optionset.");
		
		System.out.println("99. Go back.");

		try {
			reply = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			System.out.println("Wrong input. Numbers only please");
		}

		return reply;

	}

	public static void main(String[] args) {
		int reply = 0;

		CharacterBasedUI ui = new CharacterBasedUI();

		Client client = new Client("127.0.0.1", 9999);

		while (reply != -1) {
			reply = ui.menu();
			switch (reply) {
			case -1:
				client.forwardRequest(client.closePrompt());
				break;
			case 1:
				client.forwardRequest(client.filePrompt());
				break;
			case 2:
				client.forwardRequest(client.showPizzerias());
				break;
			case 3:
				client.forwardRequest(client.showPizzerias());
				client.forwardRequest(client.printPizzeria());
				break;
			case 4:
				client.forwardRequest(client.showPizzerias());
				client.forwardRequest(client.delPizzeria());
				break;
			case 5:
				client.forwardRequest(client.showPizzerias());
				reply = ui.configmenu();
				if (reply == 1)
				{
					client.forwardRequest(client.updateBasePrice());
				}
				else if (reply == 2)
				{
					client.forwardRequest(client.displayOptionsets());
					client.forwardRequest(client.addoption());
					
				}
				
				break;
			default:
				break;
			}
		}
		System.out.println("Client is disconnected from the server and exiting....");
	}

}
