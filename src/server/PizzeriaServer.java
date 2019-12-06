/**
 * 
 */
package server;

import java.io.*;
import java.net.*;

import protocol.ProtocolFactory;
import wrapper.PizzeriaConfigAPI;
import comms.*;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class PizzeriaServer implements Serializable, Runnable {

	PizzeriaConfigAPI appi = PizzeriaConfigAPI.getInstance();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int portNumber = 0;
	protected String name = null;
	protected ServerSocket serverSocket = null;
	protected boolean isDone = false;
	protected Thread runningThread = null;

	/**
	 * @param pN
	 */
	public PizzeriaServer(int pN) {
		portNumber = pN;
	}

	/**
	 * Function for server connection
	 */
	public void Connect() {
		try {
			serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			throw new RuntimeException("Cannot open port " + portNumber, e);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (this) {
			this.runningThread = Thread.currentThread();
		}
		Connect();
		while (!isDone()) {
			System.out.println("Server started");

			System.out.println("Waiting for a client ...");

			try (Socket clientSocket = serverSocket.accept();
					ObjectOutputStream out = new ObjectOutputStream(
							clientSocket.getOutputStream());
					ObjectInputStream in = new ObjectInputStream(
							clientSocket.getInputStream());) {

				Command inputLine;
				Response outputLine = null;
				

				if (clientSocket != null) {
					System.out.println("Client accepted");
				}

				inputLine = (Command) in.readObject();
				
				ProtocolFactory  protocol = new ProtocolFactory();
				outputLine = protocol.getProtocol(1, inputLine, appi);
				System.out.println(outputLine.getFeedback());
				
				
				out.writeObject(outputLine);

			} catch (IOException e) {
				

				System.out
						.println("Exception caught when trying to listen on port "
								+ portNumber + " or listening for a connection");
				System.out.println(e.getMessage());
//				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Function for closing the server
	 */
	public synchronized void closeServer() {
		this.isDone = true;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			throw new RuntimeException("Error closing server", e);
		}
	}


	private synchronized boolean isDone() {
		return this.isDone;
	}

}
