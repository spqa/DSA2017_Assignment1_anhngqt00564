package org.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.ui.MainJFrame;

public class LoadFileAction implements IClickAction{

	@Override
	public void handle(ActionEvent x) {
		JOptionPane.showConfirmDialog(MainJFrame.getFrame(), "yo bro");
	}

}
