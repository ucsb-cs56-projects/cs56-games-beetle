/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucsb.cs56.projects.games.beetle;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Dimension;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Dennis
 * @author Kevin Jih
 */
public class personGUI {
    JFrame frame = new JFrame("Person Dice Rolling Game");
    JPanel thePanel = new JPanel(new GridBagLayout());
    DrawComponent pComponent = new DrawComponent(3, 0, 0, 0, 0, 0, 0);
    DrawPanel cPanel = new DrawPanel(3, 0, 0, 0, 0, 0, 0);
    JLabel title = new JLabel("Person Dice Rolling Game!");
    JLabel pNeed = new JLabel("Player still needs");
    JLabel body = new JLabel("Body: ");
    JLabel head = new JLabel("Head: ");
    JLabel legs = new JLabel("Legs: ");
    JLabel eyes = new JLabel("Eyes: ");
    JLabel mouth = new JLabel("Mouth: ");
    JLabel cNeed = new JLabel("Computer still needs");
    JLabel arms = new JLabel("Arms: ");
    JLabel cBody = new JLabel("Body: ");
    JLabel cHead = new JLabel("Head: ");
    JLabel cLegs = new JLabel("Legs: ");
    JLabel cEyes = new JLabel("Eyes: ");
    JLabel cMouth = new JLabel("Mouth: ");
    JLabel cArms = new JLabel("Arms: ");
    JTextField pB = new JTextField("1",10);
    JTextField pH = new JTextField("1",10);
    JTextField pL = new JTextField("2",10);
    JTextField pE = new JTextField("2",10);
    JTextField pA = new JTextField("1",10);
    JTextField pT = new JTextField("2",10);
    JTextField cB = new JTextField("1",10);
    JTextField cH = new JTextField("1",10);
    JTextField cL = new JTextField("2",10);
    JTextField cE = new JTextField("2",10);
    JTextField cA = new JTextField("1",10);
    JTextField cT = new JTextField("2",10);
    private int pBN = 1; 
    private int pHN = 1; 
    private int pLN = 2; 
    private int pEN = 2; 
    private int pAN = 1; 
    private int pTN = 2; 
    private int cBN = 1; 
    private int cHN = 1; 
    private int cLN = 2; 
    private int cEN = 2; 
    private int cAN = 1; 
    private int cTN = 2; 
    JLabel info1 = new JLabel("1: Body    2: Head       3: Legs");  
    JLabel info2 = new JLabel("4: Eyes    5: Mouth      6: Arms");
    JButton roll = new JButton("Roll");
    JButton exit = new JButton("Exit");
    JButton testButton = new JButton("TEST");
    JTextArea text = new JTextArea(20,20);
    JScrollPane scroll = new JScrollPane(text);
    PPlayer player = new PPlayer();
    PPlayer computer = new PPlayer();
    Game game = new Game();
    
    
    public void setUpHomeScreen(){

	Object[] options = {"Single Player",
			    "Two Players"};
	int n = JOptionPane.showOptionDialog(frame,
					     "Please Select One",
					     "Please Select One",
					     JOptionPane.YES_NO_OPTION,
					     JOptionPane.QUESTION_MESSAGE,
					     null,     //do not use a custom Icon
					     options,  //the titles of buttons
					     options[0]); //default button title

	if(n == 0) {
	    player.setName( (String)JOptionPane.showInputDialog(
								frame,
								"Enter Player 1 Name\n",
								"Player 1",
								JOptionPane.PLAIN_MESSAGE,
								null,
								null,
								"Player 1") );

	    computer.setName("Computer");
	}

	else if(n == 1) {
	    player.setName( (String)JOptionPane.showInputDialog(
								frame,
								"Enter Player 1 Name\n",
								"Player 1",
								JOptionPane.PLAIN_MESSAGE,
								null,
								null,
								"Player 1") );
	    
	    computer.setName( (String)JOptionPane.showInputDialog(
								  frame,
								  "Enter Player 2 Name\n",
								  "Player 2",
								  JOptionPane.PLAIN_MESSAGE,
								  null,
								  null,
								  "Player 2") );
	}
	
	pNeed = new JLabel(player.getName() + " still needs");
	cNeed = new JLabel(computer.getName() + " still needs");
	
        text.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridwidth=2;
        gc.gridx=2;
        gc.gridy=0;
        frame.add(title, gc);
        gc.gridy=1;
        gc.gridheight=8;
        frame.add(scroll, gc);
        
        //player score
        gc.gridwidth=1;
        gc.gridheight=1;
	gc.gridx=0;
	gc.gridy=1;
	frame.add(pNeed, gc);
        gc.gridx=0;
        gc.gridy=2;
	frame.add(body, gc);
        gc.gridx=1;
	pB.setEditable(false);
	frame.add(pB, gc);
        gc.gridx=0;
        gc.gridy=3;
        frame.add(head, gc);
        gc.gridx=1;
	pH.setEditable(false);
        frame.add(pH, gc);
        gc.gridx=0;
        gc.gridy=4;
        frame.add(legs, gc);
        gc.gridx=1;
	pL.setEditable(false);
        frame.add(pL, gc);
        gc.gridx=0;
        gc.gridy=5;
        frame.add(eyes, gc);
        gc.gridx=1;
	pE.setEditable(false);
        frame.add(pE, gc);
        gc.gridx=0;
        gc.gridy=6;
        frame.add(mouth, gc);
        gc.gridx=1;
	pA.setEditable(false);
        frame.add(pA, gc);
        gc.gridx=0;
        gc.gridy=7;
        frame.add(arms, gc);
        gc.gridx=1;
	pT.setEditable(false);
        frame.add(pT, gc);

	//player drawing panel
	gc.gridx=0;
	gc.gridy=8;
	frame.add(pComponent, gc);
	//frame.add(testButton, gc);

        //computer score
	gc.gridx=4;
	gc.gridy=1;
	frame.add(cNeed, gc);
	gc.gridx=4;
        gc.gridy=2;
	frame.add(cBody, gc);
        gc.gridx=5;
	cB.setEditable(false);
        frame.add(cB, gc);
        gc.gridx=4;
        gc.gridy=3;
        frame.add(cHead, gc);
        gc.gridx=5;
	cH.setEditable(false);
        frame.add(cH, gc);
        gc.gridx=4;
        gc.gridy=4;
        frame.add(cLegs, gc);
        gc.gridx=5;
	cL.setEditable(false);
        frame.add(cL, gc);
        gc.gridx=4;
        gc.gridy=5;
        frame.add(cEyes, gc);
        gc.gridx=5;
	cE.setEditable(false);
        frame.add(cE, gc);
        gc.gridx=4;
        gc.gridy=6;
        frame.add(cMouth, gc);
        gc.gridx=5;
	cA.setEditable(false);
        frame.add(cA, gc);
        gc.gridx=4;
        gc.gridy=7;
        frame.add(cArms, gc);
        gc.gridx=5;
	cT.setEditable(false);
        frame.add(cT, gc);
        
        gc.gridx=2;
        gc.gridy=9;
        roll.addActionListener(new RollListener());
        frame.add(roll, gc);
        gc.gridx=3;
        exit.addActionListener(new ExitListener());
        frame.add(exit, gc);
        gc.gridwidth=2;
        gc.gridx=2;
        gc.gridy=10;
        frame.add(info1, gc);
        gc.gridy=11;
        frame.add(info2, gc);

        //frame.getContentPane().add(thePanel);
        frame.pack();
        frame.setSize(800,800);
        frame.setVisible(true);
        
        
    }
    
    class RollListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            player.roll();
            computer.roll();
            text.append(player.getName() + " rolled: " + player.getRoll() + "\n");
            text.append(player.getName() + " " + player.addPart());

	    // repaint player DrawPanel
	    pComponent.setParts( 
			    player.getBody(), 
			    player.getHead(),
			    player.getLegs(),
			    player.getEyes(),
			    player.getMouth(),
			    player.getArms() 
			     );
	    pComponent.repaint();
	    // end repaint player DrawPanel

            text.append(computer.getName() + " rolled: " + computer.getRoll() + "\n");
            text.append(computer.getName() + " " + computer.addPart());
            text.append("\n");
            pB.setText("" +(pBN - player.getBody()));
            pH.setText("" +(pHN - player.getHead()));
            pL.setText("" +(pLN - player.getLegs()));
            pE.setText("" +(pEN - player.getEyes()));
            pA.setText("" +(pAN - player.getMouth()));
            pT.setText("" +(pTN - player.getArms()));
            cB.setText("" +(cBN - computer.getBody()));
            cH.setText("" +(cHN - computer.getHead()));
            cL.setText("" +(cLN - computer.getLegs()));
            cE.setText("" +(cEN - computer.getEyes()));
            cA.setText("" +(cAN - computer.getMouth()));
            cT.setText("" +(cTN - computer.getArms()));
            
            if(player.hasWon()){
                text.append(player.getName() + " WINS!!\n\n");
                player.reset();
                computer.reset();
                pB.setText("1");
                pH.setText("1");
                pL.setText("2");
                pE.setText("2");
                pA.setText("1");
		pT.setText("2");
                cB.setText("1");
                cH.setText("1");
                cL.setText("2");
                cE.setText("2");
                cA.setText("1");
		cT.setText("2");
		pBN = 1;
		pHN = 1;
                pLN = 2;
        	pEN = 2;
		pAN = 1;
		pTN = 2;
                cBN = 1;
                cHN = 1;
                cLN = 2;
                cEN = 2;
                cAN = 1;
                cTN = 2;    
	}	
            if(computer.hasWon()){
                text.append(computer.getName() + " WINS!!\n\n");
                player.reset();
                computer.reset();
                pB.setText("1");
                pH.setText("1");
                pL.setText("2");
                pE.setText("2");
                pA.setText("1");
		pT.setText("2");
                cB.setText("1");
                cH.setText("1");
                cL.setText("2");
                cE.setText("2");
                cA.setText("1");
		cA.setText("2");
                pBN = 1;
                pHN = 1;
                pLN = 2;
                pEN = 2;
                pAN = 1;
                pTN = 2; 
                cBN = 1;
                cHN = 1;
                cLN = 2;
                cEN = 2;
                cAN = 1;
                cTN = 2;
            }
            
        }
    }//end RollListener
    class ExitListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		System.exit(0);

	}
    }//end ExitListener
}