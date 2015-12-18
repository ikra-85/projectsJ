package app.db.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ConnectDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = -3924023099181531462L;
	boolean isCancelled = true;
	
	JLabel lhost = new JLabel("Host name: ");
	JTextField host = new JTextField();

	JLabel lport = new JLabel("Port: (3306)");
	JTextField port = new JTextField();
	
	JLabel ldatabase = new JLabel("Database: ");
	JTextField database = new JTextField();
	
	JLabel luser = new JLabel("User: ");
	JTextField user = new JTextField();
	
	JLabel lpassword = new JLabel("Password: ");
	JPasswordField password = new JPasswordField();
	
	JButton cancel = new JButton("Cancel");
	JButton ok = new JButton("OK");
	
	Properties props;
	
	public ConnectDialog(JFrame owner, String title, Properties p) {
		super(owner, title, true);
		setSize(300, 200);
		setLocation(250,  200);
		props = new Properties(p);
		ok.setPreferredSize(new Dimension(75, 25));
		cancel.setPreferredSize(new Dimension(75, 25));
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		JPanel cpanel = new JPanel();
		JPanel cpanel2= new JPanel();
		
		cpanel.setLayout(new GridLayout(5, 2));
		cpanel.add( lhost );
		cpanel.add( host );
		cpanel.add( lport );
		cpanel.add( port );
		cpanel.add( ldatabase );
		cpanel.add( database );
		cpanel.add( luser );
		cpanel.add( user );
		cpanel.add( lpassword );
		cpanel.add( password );
		
		cpanel2.add( ok );
		cpanel2.add( cancel );
	
		add(cpanel, BorderLayout.NORTH);
		add(cpanel2, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok)
			isCancelled = false;
		
		this.dispose();
		
		
	}

	public Properties getProps() {

		props.setProperty("Database", database.getText());
		props.setProperty("Host_name", host.getText());
		props.setProperty("Port", port.getText());
		props.setProperty("User_name", user.getText());
		return props;
	}

}
