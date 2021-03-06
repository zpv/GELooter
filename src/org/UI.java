package org;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI {
	
	private TextField minimumValueField;
	private JButton startButton;
	
	public UI() {

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenW = screensize.width / 2;
        int screenH = screensize.height / 2;
        
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame frame = new JFrame("GE Looter - Config");
	    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JPanel namePanel = new JPanel();
		
		namePanel.add(new JLabel("Enter Minimum Item Price:"));
		minimumValueField = new TextField(20);
		minimumValueField.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!((c >= '0') && (c <= '9') ||
		           (c == KeyEvent.VK_BACK_SPACE) ||
		           (c == KeyEvent.VK_DELETE))) {
		          e.consume();
		        }
		      }
		    });
		namePanel.add(minimumValueField);
		
		JPanel actionPanel = new JPanel();
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				State.i.startScript = !State.i.startScript;
				try {
					State.i.minimumValue = Integer.parseInt(minimumValueField.getText());
				} catch (Exception ee) {
					State.i.minimumValue = 0;
				}
				frame.dispose();
			}
		});
		actionPanel.add(startButton);
		
		JPanel mainPanel = new JPanel();
		Dimension d = new Dimension(500, 150);
	    mainPanel.setSize(d);
		mainPanel.setLayout(new FlowLayout());
		mainPanel.add(new JLabel("Please support this script! Support will be used for further/new development."));
		mainPanel.add(new JLabel("Paypal: apalapa@live.ca                                       OSBot (GP): apa"));
		mainPanel.add(new JLabel("Ethereum: 0x3FBAa4462ab2F1A60b69BB9370432bEe5e768045"));
		mainPanel.add(new JLabel("----------------------------------------------------"));
		mainPanel.add(namePanel);
		mainPanel.add(actionPanel);
		
		frame.add(mainPanel);
		frame.setPreferredSize(d);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
        frame.setLocation(screenW / 2, screenH / 2);
	}
	
	public void changestartButtonText(String s) {
		startButton.setText(s);
	}
}
