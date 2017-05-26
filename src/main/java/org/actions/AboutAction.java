package org.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.ui.MainJFrame;

public class AboutAction implements IClickAction{

	@Override
	public void handle(ActionEvent x) {
		JOptionPane.showMessageDialog(MainJFrame.getFrame(), "anhngqt00564");
		
	}

}
