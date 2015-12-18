package app.db.main;

import java.util.Properties;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("DBViewer");
		Properties props = new Properties();
		ConnectDialog dialog = new ConnectDialog(frame, "DBLogin", props);
		dialog.setVisible(true);
		if (dialog.isCancelled) System.exit(0);
		
		Connector conn = new Connector(dialog.getProps(), new String(dialog.password.getPassword()));
		if (!conn.open()) System.exit(0);
		
		Database dpanel = new Database(conn);
		frame.setSize(800, 600);
		frame.add(dpanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
