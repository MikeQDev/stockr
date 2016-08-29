package io.stockr.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class NotificationSetupGUI extends JDialog {
	private int amountOfNotifications;
	private JPanel mainPanel;
	private Map<String, double[]> thresholdSettings;

	public NotificationSetupGUI(int amtOfNotifications) {
		amountOfNotifications = amtOfNotifications;
		mainPanel = new JPanel(new GridLayout(amtOfNotifications, 1));
		thresholdSettings = new HashMap<String, double[]>();
		constructTopPanel();
		constructMainPanel(amountOfNotifications);
		add(mainPanel);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Notifications");
		setAlwaysOnTop(true);
		setVisible(true);
	}

	private void constructMainPanel(final int size) {
		System.out.println(size);
		mainPanel.removeAll();
		for (int i = 0; i < size; i++) {
			final JPanel j = new JPanel();
			j.add(new JTextField(4));
			j.add(new JTextField(4));
			j.add(new JTextField(4));
			JButton removeLabel = new JButton(
					"<html><font size=\"3\">-</font></html>");
			removeLabel.setPreferredSize(new Dimension(27, 20));
			removeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			removeLabel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(((JTextField) j.getComponent(0))
							.getText());
				}
			});
			j.add(removeLabel);
			JButton saveButton = new JButton(
					"<html><font size=\"3\">s</font></html>");
			saveButton.setPreferredSize(new Dimension(27, 20));
			saveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						double high = Double.parseDouble(((JTextField) j
								.getComponent(1)).getText());
						double low = Double.parseDouble(((JTextField) j
								.getComponent(2)).getText());
						String symbol = ((JTextField) j.getComponent(0))
								.getText();
						System.out.println(symbol + "..." + high + "..." + low);
						thresholdSettings.put(symbol, new double[]{high, low});
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			j.add(saveButton);

			mainPanel.add(j);
		}
		pack();
	}

	private void constructTopPanel() {
		final JPanel topPanel = new JPanel();
		topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JButton addLabel = new JButton("<html><font size=\"3\">+</font></html>");
		addLabel.setPreferredSize(new Dimension(27, 20));
		addLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		addLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						constructMainPanel(++amountOfNotifications);
					}
				});

			}
		});

		topPanel.add(new JLabel("Symbol     " + "Lower     " + "Upper    "));
		topPanel.add(addLabel);
		add(topPanel, BorderLayout.NORTH);
	}
}
