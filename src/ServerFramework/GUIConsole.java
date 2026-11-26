/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServerFramework;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;

/**
 *
 * @author jaden
 */
public class GUIConsole extends JFrame implements ChatIF {

    ChatClient client;

    private JButton closeB = new JButton("Close");
    private JButton openB = new JButton("Open");
    private JButton sendB = new JButton("Send");
    private JButton quitB = new JButton("Quit");
    private JButton loginB = new JButton("Login");

    private JTextField portTxF = new JTextField("5555");
    private JTextField hostTxF = new JTextField("127.0.0.1");
    private JTextField userTxF = new JTextField(" ");
    private JTextField loginTxF = new JTextField("");
    private JTextField messageTxF = new JTextField("");

    private JLabel portLB = new JLabel("Port: ", JLabel.RIGHT);
    private JLabel hostLB = new JLabel("Host: ", JLabel.RIGHT);
    private JLabel userLB = new JLabel("User Name: ", JLabel.RIGHT);
    private JLabel messageLB = new JLabel("Message: ", JLabel.RIGHT);

    private JTextArea messageList = new JTextArea();

    public GUIConsole(String host, int port) {

        super("Simple Chat GUI");
        setSize(300, 400);

        setLayout(new BorderLayout(5, 5));
        JPanel bottom = new JPanel();
        add("Center", messageList);
        add("South", bottom);

        bottom.setLayout(new GridLayout(7, 2, 5, 5));
        bottom.add(hostLB);
        bottom.add(hostTxF);
        bottom.add(portLB);
        bottom.add(portTxF);

        bottom.add(userLB);
        bottom.add(userTxF);

        bottom.add(messageLB);
        bottom.add(messageTxF);
        bottom.add(openB);
        bottom.add(sendB);
        bottom.add(closeB);
        bottom.add(quitB);

        setVisible(true);

        sendB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                send(messageTxF.getText());
            }
        });

        openB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (client != null && client.isConnected()) {
                    display("You are already connected");
                } else {
                    String host = hostTxF.getText();
                    int port = Integer.parseInt(portTxF.getText());
                    String userName = userTxF.getText();
                    System.out.println("User name of openB: " + userName);
                    connectToServer(host, port, userName);
                }
            }
        });

        closeB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = "#logoff";
                send(message);
            }
        });
        
        quitB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = "#quit";
                send(message);
            }
        });
        
    }

    public void send(String message) {
        client.handleMessageFromClientUI(message);
    }

    public void display(String message) {
        messageList.insert(message + "\n", 0);
    }

    public void connectToServer(String host, int port, String userName) {
        try {
            client = new ChatClient(host, port, this, userName);
        } catch (IOException exception) {
            System.out.println("Error: Can't setup connection!!!!"
                    + " Terminating client.");
            System.exit(1);
        }
    }

    //test driver
    public static void main(String[] args) {
        GUIConsole gui = new GUIConsole("127.0.0.1", 5555);

    }
}
