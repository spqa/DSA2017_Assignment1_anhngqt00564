package org.main;

import java.awt.Dimension;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {

	public static void main(String[] args) {
		// Person temp = new Person("haha");
		// System.out.println(temp);
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		JTable jTable = new JTable();
		JPanel jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension(500, 500));
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn(new String[] { "col1", "col2", "col3" });
		tableModel.addRow(new String[] { "haha", "A1", "A2" });

		jTable.setPreferredSize(new Dimension(500, 500));
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(500, 500));
		jTable.setModel(tableModel);
		jScrollPane.add(jTable);
		jPanel.add(jScrollPane);

		frame.setContentPane(jPanel);

		frame.setVisible(true);

	}

}
