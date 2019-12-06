/**
 * 
 */
package gui;

import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.*;

import comms.*;
import exceptions.CustomExceptionFactory;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor
 * received unauthorized assistance on this work.
 * 
 * @author Derrick Odonkor
 * 
 */
public class GUI {

	JFrame f;
	JRadioButton r1;
	JRadioButton r2;
	ButtonGroup bg;
	final JComboBox cb;
	final JTextArea tf;
	JButton b;
	JButton b2;
	JLabel l1, l2, l3;
	CommandList action = null;
	Command cmd = null;
	String[] languages;

	public GUI() {

		f = new JFrame();// creating instance of JFrame

		l1 = new JLabel("Actions");
		l1.setBounds(40, 30, 100, 30);
		l2 = new JLabel("Pizzerias");
		l2.setBounds(280, 30, 100, 30);
		l3 = new JLabel();
		l3.setBounds(40, 10, 100, 30);
		f.add(l1);
		f.add(l2);
		f.add(l3);

		r1 = new JRadioButton("Display pizzeria");
		r2 = new JRadioButton("Update baseprice");
		r1.setBounds(25, 50, 150, 70);
		r2.setBounds(25, 100, 150, 70);
		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		f.add(r1);
		f.add(r2);

		cb = new JComboBox();
		cb.setBounds(250, 70, 90, 20);
		forwardRequest(new Command(CommandList.SHOWPIZZERRIAS, null, null,
				null, null, 0));
		tf = new JTextArea();
		tf.setBounds(25, 300, 200, 150);

		b = new JButton("Execute");// creating instance of JButton
		b.setBounds(130, 250, 100, 40);

		b2 = new JButton("Update");// creating instance of JButton
		b2.setBounds(250, 350, 100, 40);
		b2.setEnabled(false);

		r1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (r1.isSelected()) {

					b.setEnabled(true);
					tf.setText("");
					b2.setEnabled(false);

				}
			}

		});
		r2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (r2.isSelected()) {

					String value = cb.getSelectedItem().toString();
					forwardRequest(new Command(CommandList.DISPLAYBASEPRICE,
							null, value, null, null, 0));
					b2.setEnabled(true);
					b.setEnabled(false);
				}
			}

		});

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (r1.isSelected()) {

					String value = cb.getSelectedItem().toString();
					forwardRequest(new Command(CommandList.PRINTPIZZERIA, null,
							value, null, null, 0));

				}

			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pn = cb.getSelectedItem().toString();
				double bp = Double.parseDouble(tf.getText());
				// System.out.println(pn +" "+bp);
				forwardRequest(new Command(CommandList.BASEPRICE, null, pn,
						null, null, bp));
				bg.clearSelection();
				
				b2.setEnabled(false);
			}
		});

		f.add(b);// adding button in JFrame
		f.add(b2);
		f.add(cb);
		f.add(tf);

		f.setSize(400, 500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible

	}

	public void forwardRequest(Command cmd) {
		String hostName = "127.0.0.1";
		int portNum = 9999;

		try (Socket kkSocket = new Socket(hostName, portNum);
				ObjectOutputStream out = new ObjectOutputStream(
						kkSocket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(
						kkSocket.getInputStream());) {
			Response fromServer = null;
			int reply = 0;

			out.writeObject(cmd);
			fromServer = (Response) in.readObject();

			if (fromServer.getCommand().equals(CommandList.UPL)) {
				tf.setText("From Server: " + fromServer.getFeedback());
			} else if (fromServer.getCommand() == CommandList.SHOWPIZZERRIAS) {

				ArrayList<String> list = fromServer.getList();

				for (String str : list) {
					cb.addItem(str);
				}

			} else if (fromServer.getCommand() == CommandList.PRINTPIZZERIA) {

				tf.setText("" + (fromServer.getPizzaConfig().toString()));

			} else if (fromServer.getCommand() == CommandList.BASEPRICE) {
				tf.setText("");
				tf.setText("From Server: \n" + fromServer.getFeedback());
			} else if (fromServer.getCommand() == CommandList.DISPLAYBASEPRICE) {
				tf.setText("" + (fromServer.getPizzaConfig().getBasePrice()));
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
	 * @param args
	 */
	public static void main(String[] args) {
		new GUI();
	}

}
