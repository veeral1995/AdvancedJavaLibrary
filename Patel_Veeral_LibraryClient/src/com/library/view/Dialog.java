package com.library.view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Dialog extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5669384463178310650L;
	JButton okBtn = new JButton("OK");
	JLabel label = new JLabel();

	public Dialog(String title, String msg) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(title);
		label.setText(msg);
		jbInit();
		okBtn.addActionListener(this);
	}

	private void jbInit() {
		label.setBounds(new Rectangle(56, 15, 197, 40));
		okBtn.setBounds(new Rectangle(114, 70, 68, 23));
		this.getContentPane().add(label);
		this.getContentPane().add(okBtn);
		getContentPane().setLayout(null);
		setSize(300, 150);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == okBtn) {
			dispose();
		}
	}
}
