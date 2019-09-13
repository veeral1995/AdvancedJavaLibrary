package com.library.view;

import javax.swing.UIManager;

import com.library.view.ViewDriver;
import org.apache.log4j.BasicConfigurator;

public class ViewDriver {

	 public ViewDriver() 
	    {
	       try {
	         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	       }
	       catch (Exception e) {
	         e.printStackTrace();
	       }
	       
	        MainJFrame mainJFrame = new MainJFrame();
	        MainJFrameController mainJFrameController = new MainJFrameController(mainJFrame);
	        
	    }
	 
	 public static void main(String[] args) {
                   BasicConfigurator.configure();
		   new ViewDriver();
		 }
}
