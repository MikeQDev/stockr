package io.stockr.gui;

import java.awt.BorderLayout;
import java.awt.DisplayMode;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@Deprecated
public class OldNotificationGUI {
	private String[] userValues = new String[3];
	private String symbol;
	private JPanel mainPanel = new JPanel(new GridLayout(3, 2));
	private JLabel highLabel = new JLabel("High: ");
	private JLabel lowLabel = new JLabel("Low: ");
	private JLabel emailLabel = new JLabel("Email: ");
	private JLabel addForLabel;
	private JTextField highText = new JTextField();
	private JTextField lowText = new JTextField();
	private JTextField emailText = new JTextField();
	private JButton setButton = new JButton("Set notification");
	private JDialog frame;

	public void getNotifications() {
		userValues[1] = "ahh";
		setButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double.parseDouble(highText.getText());
					Double.parseDouble(lowText.getText());
					userValues[0] = highText.getText();
					userValues[1] = lowText.getText();
					userValues[2] = emailText.getText();
					frame.dispose();
				} catch (NumberFormatException ex) {
					System.out.println("dun good");
				}
			}
		});

		mainPanel.add(highLabel);
		mainPanel.add(highText);
		mainPanel.add(lowLabel);
		mainPanel.add(lowText);
		mainPanel.add(emailLabel);
		mainPanel.add(emailText);

		frame.add(addForLabel, BorderLayout.NORTH);
		frame.add(mainPanel);
		frame.add(setButton, BorderLayout.SOUTH);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setTitle(symbol + " notification");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		while (userValues[2] == null) {
			System.out.println("xx");
		}
		//return userValues;
	}

	public OldNotificationGUI(String symbol) {
		this.symbol = symbol;
		addForLabel = new JLabel(symbol);
		frame = new JDialog();
	}
}
