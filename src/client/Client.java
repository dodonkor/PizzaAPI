/**
 * 
 */
package client;

import io.FileConfig;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Properties;

import comms.*;
import exceptions.CustomExceptionFactory;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class Client {

	String hostName = "";
	int portNumber = 0;

	/**
	 * @param hostname
	 * @param portnum
	 */
	public Client(String hostname, int portnum) {
		hostName = hostname;
		portNumber = portnum;
	}

	/**
	 * @param cmd
	 */
	public void forwardRequest(Command cmd) {

		try (Socket kkSocket = new Socket(hostName, portNumber);
				ObjectOutputStream out = new ObjectOutputStream(
						kkSocket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(
						kkSocket.getInputStream());) {
			Response fromServer = null;
			
			if(cmd.getCommand().equals(CommandList.EXIT))
			{
				in.close();
				out.close();
				return;
			}
			out.writeObject(cmd);
			fromServer = (Response) in.readObject();

			if (fromServer.getCommand().equals(CommandList.UPL)) {
				System.out.println("From Server: " + fromServer.getFeedback());
			} else if (fromServer.getCommand() == CommandList.SHOWPIZZERRIAS) {
				ArrayList<String> list = fromServer.getList();
				for (String str : list) {
					System.out.println(str);
				}
			} else if (fromServer.getCommand() == CommandList.PRINTPIZZERIA) {

				try {
					fromServer.getPizzaConfig().displayPizzeria();
				} catch (CustomExceptionFactory e) {
					e.printStackTrace();
				}
			} else if (fromServer.getCommand() == CommandList.DEL) {

				if (fromServer.getPizzaConfig() != null) {
					System.out.println("From Server: "
							+ fromServer.getFeedback());
				}
			}else if (fromServer.getCommand() == CommandList.BASEPRICE) {
				System.out.println("From Server: " + fromServer.getFeedback());
			}else if (fromServer.getCommand() == CommandList.OPTIONSET) {
				
				ArrayList<String> list = fromServer.getList();
				for (String str : list) {
					System.out.println(str);
				}
			
			}else if (fromServer.getCommand() == CommandList.ADDOPTION) {
				System.out.println("From Server: " + fromServer.getFeedback());
			
			}

			

		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to "
					+ hostName);
			System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param filepath
	 * @return
	 */
	public Command readPropFile(String filepath) {
		FileConfig fileconfig = new FileConfig();

		try {
			Properties propfile = fileconfig.buildPizzaConfigProp(filepath);
			Command newCom = new Command(CommandList.UPL, propfile, null, null,
					null, 0);

			return newCom;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * @return
	 */
	public Command filePrompt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String reply = "";
		System.out.println("Please enter the path to the file.");
		try {
			reply = br.readLine();
		} catch (IOException e) {
			System.out.println("Wrong input. Numbers only please");
		}

		if (!reply.equals("")) {
			return readPropFile(reply);
		} else
			return null;

	}

	/**
	 * @return
	 */
	public Command showPizzerias() {

		Command newCom = new Command(CommandList.SHOWPIZZERRIAS, null, null,
				null, null,0);

		return newCom; 

	}

	/**
	 * @return
	 */
	public Command printPizzeria() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String reply = "";
		System.out
				.println("Please enter the name of the Pizzerria name from the list provided.");
		try {
			reply = br.readLine();
		} catch (IOException e) {
			System.out.println("Wrong input. Numbers only please");
		}

		Command newCom = new Command(CommandList.PRINTPIZZERIA, null, reply,
				null, null, 0);

		return newCom;

	}

	/**
	 * @return
	 */
	public Command delPizzeria() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String reply = "";
		System.out
				.println("Please enter the name of the Pizzerria name from the list provided to delete.");
		try {
			reply = br.readLine();
		} catch (IOException e) {
			System.out.println("Wrong input. Numbers only please");
		}

		Command newCom = new Command(CommandList.DEL, null, reply, null, null, 0);

		return newCom; 

	}
	
	/**
	 * @return
	 */
	public Command updateBasePrice() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String reply = "";
		double price = 0.0;
		
		try {			
			System.out
			.println("Please enter the pizzerianame from the list.");
			reply = br.readLine();
			
			System.out
			.println("Please enter the new baseprice.");
			price = Double.parseDouble(br.readLine());
		} catch (IOException e) {
			System.out.println("Wrong input. Numbers only please");
		}

		Command newCom = new Command(CommandList.BASEPRICE, null, reply, null, null, price);

		return newCom; 

	}
	
	/**
	 * @return
	 */
	public Command addoption() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pizzerianame = "";
		String optionset = "";
		String option = "";
		
		try {			
			System.out
			.println("Please enter the pizzeria name from the list.");
			pizzerianame = br.readLine();
			
			System.out
			.println("Please enter the optionset name from the list.");
			optionset = br.readLine();
			
			System.out
			.println("Please enter the new option.");
			option = br.readLine();
		} catch (IOException e) {
//			System.out.println("Wrong input. Numbers only please");z
		}

		Command newCom = new Command(CommandList.ADDOPTION, null,pizzerianame,optionset,option, 0);

		return newCom; 

	}

	/**
	 * @return
	 */
	public Command configPizzeria() {
		Command newCom = new Command(CommandList.CONFIG, null, null, null,
				null,0);
		return newCom;
	}

	/**
	 * @return
	 */
	public Command closePrompt() {
		Command newCom = new Command(CommandList.EXIT, null, null, null,
				null,0);
		return newCom;
	}
	
	/**
	 * @return
	 */
	public Command displayOptionsets() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pizzerianame="";
		
		try {
			System.out
			.println("Please enter the pizzeria name from the list.");
			pizzerianame = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Command newCom = new Command(CommandList.OPTIONSET, null, pizzerianame, null,
				null,0);
		return newCom;
	}

}
