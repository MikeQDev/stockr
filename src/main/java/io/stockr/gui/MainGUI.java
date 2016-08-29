package io.stockr.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import io.stockr.fileio.FileIO;
import io.stockr.scrape.Scrape;

public class MainGUI extends JFrame {
	private final ImageIcon REDLABEL = new ImageIcon(getClass().getResource("/images/red.png")),
			GREENLABEL = new ImageIcon(getClass().getResource("/images/green.png")),
			BLACKLABEL = new ImageIcon(getClass().getResource("/images/black.png"));

	private JPanel[] subpanels;
	private JLabel lastUpdateLabel = new JLabel("Updated: ??:??:??");
	private DecimalFormat dF = new DecimalFormat("#,###.00");
	private List<String> trackedStocks;
	private Dragger drag = new Dragger();
	private Timer updateTimer;
	private UpdateScheduler uS;
	private int refreshTime = 30000, textSize = 12;
	private JPanel masterPanel, masterGraphPanel;
	private HashMap<String, String> pricesBeforeUpdate = new HashMap<String, String>();
	private boolean firstRun = true;

	// change size, save size and location on screen

	public MainGUI(List<String> stocksToTrack) {
		super("Stockr");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		if (stocksToTrack == null) {
			trackedStocks = new ArrayList<String>();
		} else
			trackedStocks = stocksToTrack;

		constructPanels();

		setVisible(true);
		this.setLocation(700, 400);
		this.setAlwaysOnTop(true);

		updateTimer = new Timer();
		uS = new UpdateScheduler();
		updateTimer.schedule(uS, 0, refreshTime);
	}

	private void changeUpdateInterval(int interval) {
		refreshTime = interval * 1000;
		uS.cancel();
		uS = new UpdateScheduler();
		updateTimer.schedule(uS, 0, refreshTime);
	}

	private void constructPanels() {
		getContentPane().removeAll();
		Font font = new Font("DIALOG", Font.BOLD, textSize);
		masterGraphPanel = new JPanel(new GridLayout(trackedStocks.size(), 1));
		if (!firstRun) {
			pricesBeforeUpdate.clear();
			for (int i = 0; i < subpanels.length; i++) {
				pricesBeforeUpdate.put(((JLabel) subpanels[i].getComponent(0)).getText(),
						((JLabel) subpanels[i].getComponent(1)).getText());
			}
		}
		for (int i = 0; i < trackedStocks.size(); i++) {
			JLabel tooltipLabel = new JLabel(BLACKLABEL);
			masterGraphPanel.add(tooltipLabel);
		}
		add(masterGraphPanel, BorderLayout.EAST);
		// add(new JScrollPane(masterGraphPanel), BorderLayout.EAST);

		masterPanel = new JPanel(new GridLayout(trackedStocks.size(), 1));
		subpanels = new JPanel[trackedStocks.size()];

		for (int i = 0; i < trackedStocks.size(); i++) {
			subpanels[i] = new JPanel(new GridLayout());
			JLabel sym = null;
			if (trackedStocks.get(i).length() <= 5) {
				sym = new JLabel(trackedStocks.get(i), SwingConstants.LEADING);
			} else
				sym = new JLabel(trackedStocks.get(i).substring(0, 3) + "...", SwingConstants.LEADING);
			JLabel price = new JLabel();
			if (pricesBeforeUpdate.containsKey(sym.getText()))
				price.setText(pricesBeforeUpdate.get(sym.getText()).toString());
			else
				price.setText("??,???.??");

			sym.setFont(font);
			price.setFont(font);
			subpanels[i].add(sym);
			subpanels[i].add(price);
			masterPanel.add(subpanels[i]);
		}
		lastUpdateLabel = new JLabel("??:??:??");
		lastUpdateLabel.setText("Updated: " + new SimpleDateFormat("hh:mm:ss").format(new Date()));

		masterPanel.addMouseListener(drag);
		masterPanel.addMouseMotionListener(drag);
		lastUpdateLabel.addMouseMotionListener(drag);
		lastUpdateLabel.addMouseListener(drag);

		add(new JScrollPane(masterPanel));
		add(lastUpdateLabel, BorderLayout.SOUTH);
		pack();
		firstRun = false;
	}

	public class UpdateScheduler extends TimerTask {
		@Override
		public void run() {
			masterGraphPanel.removeAll();
			for (int i = 0; i < trackedStocks.size(); i++) {
				Double[] scrapeResults = Scrape.getPrice(trackedStocks.get(i));
				double price = scrapeResults[0];
				char color = 'b';
				if (scrapeResults[1] == 1) {
					color = 'g';
				} else if (scrapeResults[1] == -1) {
					color = 'r';
				}

				if (price == -1) {
					((JLabel) subpanels[i].getComponent(1)).setText("Invalid");
					continue;
				}
				// NotificationManager.checkForNotifications(trackedStocks.get(i),
				// price);

				try {
					((JLabel) subpanels[i].getComponent(1)).setText(dF.format(price).toString());
					JLabel tooltipLabel;
					if (color == 'r') {
						tooltipLabel = new JLabel(REDLABEL);
					} else if (color == 'g') {
						tooltipLabel = new JLabel(GREENLABEL);
					} else {
						tooltipLabel = new JLabel(BLACKLABEL);

					}
					tooltipLabel.setToolTipText(
							"<html><img src=\"" + "http://chart.finance.yahoo.com/t?s=" + trackedStocks.get(i)
							// + "&width=300&height=180"
									+ "&width=" + (textSize * 15) + "&height=" + (textSize * 10) + "\"/></html>");

					masterGraphPanel.add(tooltipLabel);
					add(masterGraphPanel, BorderLayout.EAST);
				} catch (Exception ex) {

				}
			}
			lastUpdateLabel.setText("Updated: " + new SimpleDateFormat("hh:mm:ss").format(new Date()));

		}
	}

	class Dragger extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {

			if (SwingUtilities.isRightMouseButton(e)) {
				JPopupMenu leftClickMenu = new JPopupMenu();

				JMenuItem addItem = new JMenuItem("Add symbol...");
				addItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String x = JOptionPane.showInputDialog(null, "New stock symbol:", "Add symbol",
									JOptionPane.PLAIN_MESSAGE);
							if (x == null || x.equals(""))
								return;
							if (!trackedStocks.contains(x.toUpperCase())) {
								trackedStocks.add(x.toUpperCase());
								constructPanels();
							}
						} catch (Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, "Invalid input");
						}
					}
				});

				leftClickMenu.add(addItem);

				JMenu changeSizeItem = new JMenu("Size");

				JMenuItem size5 = new JMenuItem("12");
				size5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textSize = 12;
						constructPanels();
					}
				});
				JMenuItem size10 = new JMenuItem("16");
				size10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textSize = 16;
						constructPanels();
					}
				});
				JMenuItem size15 = new JMenuItem("20");
				size15.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textSize = 20;
						constructPanels();
					}
				});
				JMenuItem size32 = new JMenuItem("32");
				size32.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textSize = 32;
						constructPanels();
					}
				});
				JMenuItem sizeCustom = new JMenuItem("...");
				sizeCustom.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String x = JOptionPane.showInputDialog(null, "Set text size:", "Text size",
									JOptionPane.PLAIN_MESSAGE);
							if (x == null)
								return;
							int newSize = Integer.parseInt(x);
							textSize = newSize;
							constructPanels();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Invalid input");
						}
					}
				});

				changeSizeItem.add(size5);
				changeSizeItem.add(size10);
				changeSizeItem.add(size15);
				changeSizeItem.add(size32);
				changeSizeItem.add(sizeCustom);

				// if clicking on a stock directly...
				if (!(e.getComponent() instanceof JLabel)) {
					final MouseEvent mEvent = e;
					JMenuItem removeItem = new JMenuItem("Remove symbol");
					removeItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							int idxToRemove = mEvent.getY()
									/ ((JComponent) mEvent.getSource()).getComponent(0).getHeight();
							trackedStocks.remove(idxToRemove);
							constructPanels();

						}
					});
					JMenuItem setNotificationItem = new JMenuItem("Set notifications...");
					setNotificationItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							int idxToRemove = mEvent.getY()
									/ ((JComponent) mEvent.getSource()).getComponent(0).getHeight();

						}
					});
					setNotificationItem.setEnabled(false);

					leftClickMenu.add(setNotificationItem);
					leftClickMenu.add(removeItem);
				}

				JMenu refreshItem = new JMenu("Refresh interval");

				JMenuItem refresh5 = new JMenuItem("5 sec");
				refresh5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changeUpdateInterval(5);
					}
				});
				JMenuItem refresh30 = new JMenuItem("30 sec");
				refresh30.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changeUpdateInterval(30);
					}
				});
				JMenuItem refresh60 = new JMenuItem("60 sec");
				refresh60.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						changeUpdateInterval(60);
					}
				});
				JMenuItem refreshCustom = new JMenuItem("Custom...");
				refreshCustom.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String x = JOptionPane.showInputDialog(null, "Set update interval (in seconds):",
									"Update interval", JOptionPane.PLAIN_MESSAGE);
							if (x == null)
								return;
							int newTime = Integer.parseInt(x);
							changeUpdateInterval(newTime);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Invalid input");
						}
					}
				});

				refreshItem.add(refresh5);
				refreshItem.add(refresh30);
				refreshItem.add(refresh60);
				refreshItem.add(refreshCustom);

				JMenuItem exitItem = new JMenuItem("Exit");
				exitItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FileIO.saveStocksToFile(trackedStocks);
						System.exit(0);
					}
				});

				JMenuItem helpItem = new JMenuItem("Help");
				helpItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,
								"Stockr - an app (widget?) for keeping track of stock prices."
										+ "\nOriginally an enterprise-level project, but dropped to"
										+ "\nindividual-use due to lack of users." + "\n"
										+ "\nAll prices are up-to-date and scraped from Yahoo Finance."
										+ "\nCan't find a symbol? Look it up on Yahoo Finance."
										+ "\nLeave this JAR file in same dir as 'mystocks.txt'"
										+ "\nStocks are automatically saved upon right click > exit." + "\n"
										+ "\nCreated by Mike, Jan. 2016",
								"Help", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				leftClickMenu.add(changeSizeItem);
				leftClickMenu.add(refreshItem);
				leftClickMenu.add(helpItem);
				leftClickMenu.add(exitItem);

				leftClickMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			setLocation(new Point(e.getXOnScreen() - (getWidth() / 2), e.getYOnScreen() - (getHeight() / 2)));

		}
	}
}