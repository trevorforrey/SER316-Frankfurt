package net.sf.memoranda.ui.DevelopHomePage;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class MainToolBar extends JToolBar implements Styling{
	private JButton button;
	public MainToolBar()
	{
		
		createComponents();
		editComponents();
		addActionListeners();
		addComponents();
	}
	
	private void createComponents() {
		// TODO Auto-generated method stub
		
	}

	private void editComponents() {
		this.setPreferredSize(new Dimension(Styling.MAIN_TOOLBAR_WIDTH,Styling.MAIN_TOOLBAR_HEIGHT));
		this.setMaximumSize(new Dimension(Styling.MAIN_TOOLBAR_WIDTH,Styling.MAIN_TOOLBAR_HEIGHT));
		this.setLocation(0, Styling.SCREEN_HEIGHT/2 - Styling.MAIN_TOOLBAR_HEIGHT);
	}

	private void addActionListeners() {
		// TODO Auto-generated method stub
		
	}

	private void addComponents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void style() {
		// TODO Auto-generated method stub
		
	}
}