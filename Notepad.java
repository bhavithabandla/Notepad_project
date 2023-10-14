import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Notepad implements ActionListener {
	JFrame frm;
	JMenuBar mb;
	JMenu m1, m2, m3;
	JMenuItem save, copy, cut, select, paste;
	JTextArea txt;

	Notepad() {
		frm = new JFrame();
		txt = new JTextArea();
		mb = new JMenuBar();
		m1 = new JMenu("file");
		m2 = new JMenu("edit");
		m3 = new JMenu("help");
		save = new JMenuItem("save as");
		cut = new JMenuItem("cut");
		copy = new JMenuItem("copy");
		paste = new JMenuItem("paste");
		select = new JMenuItem("select all");
		m1.add(save);
		m2.add(cut);
		m2.add(copy);
		m2.add(paste);
		m2.add(select);
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.setBounds(1, 1, 500, 20);
		txt.setBounds(1, 30, 500, 500);
		save.addActionListener(this);
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		select.addActionListener(this);
		frm.add(txt);
		frm.add(mb);
		frm.setLayout(null);
		frm.setSize(500, 500);
		frm.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == save) {
			JFileChooser j = new JFileChooser();
			int r = j.showSaveDialog(null);
			if (r == JFileChooser.APPROVE_OPTION) {
				File fl = new File(j.getSelectedFile().getAbsolutePath());
				try {
					FileWriter w = new FileWriter(fl, false);
					w.write(txt.getText());
					w.flush();
					w.close();
				} catch (Exception ee) {
					System.out.println(ee);
				}
			}
		}
		if (e.getSource() == copy)
			txt.copy();
		if (e.getSource() == cut)
			txt.cut();
		if (e.getSource() == paste)
			txt.paste();
		if (e.getSource() == select)
			txt.selectAll();
	}

	public static void main(String arg[]) {
		Notepad n = new Notepad();
	}
}