/**************************************************************
 * Copyright (c) 2017 - 2017, Joshua Becker, All rights reserved
 * SER316-Frankfurt
 * Description: this is the frame for the project
 */
package net.sf.memoranda.ui.DevelopHomePage;

import javax.swing.*;

import net.sf.memoranda.EventsScheduler;
import net.sf.memoranda.ui.App;
import net.sf.memoranda.ui.AppFrame;
import net.sf.memoranda.ui.ExceptionDialog;
import net.sf.memoranda.util.Configuration;

import java.awt.*;
import java.util.Calendar;

/**
 * The Class Develop.
 * is the jframe for the project.
 */
public class Develop extends JFrame
{
	
	/** The screen width. */
	public static int SCREEN_WIDTH;
	
	/** The screen height. */
	public static int SCREEN_HEIGHT;
	
	private JFrame splash;
    
    /**
     * Instantiates a new develop.
     */
    public Develop(boolean fullmode)
    {
    	super();
		if (fullmode)
			fullmode = !Configuration.get("START_MINIMIZED").equals("yes");
		/* DEBUG */
		if (!fullmode)
			System.out.println("Minimized mode");
		if (!Configuration.get("SHOW_SPLASH").equals("no"))
			showSplash();
		try {
			if (Configuration.get("LOOK_AND_FEEL").equals("system"))
				UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
			else if (Configuration.get("LOOK_AND_FEEL").equals("default"))
				UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());					
			else if (
				Configuration.get("LOOK_AND_FEEL").toString().length() > 0)
				UIManager.setLookAndFeel(
					Configuration.get("LOOK_AND_FEEL").toString());

		} catch (Exception e) {		    
			new ExceptionDialog(e, "Error when initializing a pluggable look-and-feel. Default LF will be used.", "Make sure that specified look-and-feel library classes are on the CLASSPATH.");
		}
		if (Configuration.get("FIRST_DAY_OF_WEEK").equals("")) {
			String fdow;
			if (Calendar.getInstance().getFirstDayOfWeek() == 2)
				fdow = "mon";
			else
				fdow = "sun";
			Configuration.put("FIRST_DAY_OF_WEEK", fdow);
			Configuration.saveConfig();
			/* DEBUG */
			System.out.println("[DEBUG] first day of week is set to " + fdow);
		}

		EventsScheduler.init();
		if (fullmode) {
			this.init();
		}
		if (!Configuration.get("SHOW_SPLASH").equals("no"))
			splash.dispose();
    }
    
    void init() {
		/*
		 * if (packFrame) { frame.pack(); } else { frame.validate(); }
		 * 
		 * Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 * 
		 * Dimension frameSize = frame.getSize(); if (frameSize.height >
		 * screenSize.height) { frameSize.height = screenSize.height; } if
		 * (frameSize.width > screenSize.width) { frameSize.width =
		 * screenSize.width; }
		 * 
		 * 
		 * Make the window fullscreen - On Request of users This seems not to
		 * work on sun's version 1.4.1_01 Works great with 1.4.2 !!! So update
		 * your J2RE or J2SDK.
		 */
		/* Used to maximize the screen if the JVM Version if 1.4 or higher */
		/* --------------------------------------------------------------- */
		double JVMVer =
			Double
				.valueOf(System.getProperty("java.version").substring(0, 3))
				.doubleValue();

		HomePanel hp = new HomePanel();
		hp.setPreferredSize(new Dimension(Develop.SCREEN_WIDTH,Develop.SCREEN_HEIGHT));
		this.add(hp);
		this.pack();
		if (JVMVer >= 1.4) {
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
		} else {
			this.setExtendedState(Frame.NORMAL);
		}
		/* --------------------------------------------------------------- */
		/* Added By Jeremy Whitlock (jcscoobyrs) 07-Nov-2003 at 15:54:24 */

		// Not needed ???
		this.setVisible(true);
		this.toFront();
		this.requestFocus();

	}
    
    //taken from App.java
	/**
	 * Method showSplash.
	 */
	private void showSplash() {
		splash = new JFrame();
		ImageIcon spl =
			new ImageIcon(App.class.getResource("resources/splash.png"));
		JLabel l = new JLabel();
		l.setSize(400, 300);
		l.setIcon(spl);
		splash.getContentPane().add(l);
		splash.setSize(400, 300);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		splash.setLocation(
			(screenSize.width - 400) / 2,
			(screenSize.height - 300) / 2);
		splash.setUndecorated(true);
		splash.setVisible(true);
	}
}