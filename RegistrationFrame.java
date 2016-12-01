package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RegistrationFrame extends JFrame{

	public RegistrationFrame() throws ClassNotFoundException{
		setSize(550,730);
		Container contentPane = getContentPane();
		RegistrationPanel panel = new RegistrationPanel();
		contentPane.add(panel);
	}
}

class RegistrationPanel extends JPanel{
	
	private BufferedImage back, logo;
	static JFrame frame1;
	
	public RegistrationPanel(){
		setLayout(null);
		try {                
	          back = ImageIO.read(new File("Pictures/background.png"));
	          logo = ImageIO.read(new File("Pictures/logo.png"));
	       } catch (IOException ex) {}
		
		JTextField nick = new JTextField(20);
		add(nick).setBounds(115, 300, 300, 35);
		JTextField email = new JTextField(15);
		add(email).setBounds(115, 350, 300, 35);
		JTextField password = new JTextField(15);
		add(password).setBounds(115, 400, 300, 35);
		JButton sign_up = new JButton("Зарегистрироваться");
		sign_up.setForeground(Color.WHITE);
		sign_up.setBackground(new Color(102, 	0, 	255));
		add(sign_up).setBounds(165, 450, 200, 50);
		JLabel label = new JLabel("Уже имеете аккаунт?");
		add(label).setBounds(210,535,200,20);
		JButton sign_in = new JButton("Зайти в аккаунт");
		sign_in.setForeground(Color.WHITE);
		sign_in.setBackground(new Color(102, 	0, 	255));
		add(sign_in).setBounds(165, 565, 200, 50);
		
	    sign_up.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			Main_Test.frame.dispose();	
			try{
			frame1 = new LevelTest();
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);
			
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
	    }
	});

	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(back, 0, 0, 550, 700, this);
        g.setColor(Color.pink);
        g.fillRect(60, 60, 410, 575);
        g.setColor(Color.white);
        g.fillOval(130, 10, 270, 270);
        g.drawImage(logo, 160, 20, 210, 210, this);
        /*g.setColor(Color.lightGray);
        g.fillRect(115, 300, 300, 35);//user.nick
        g.fillRect(115, 345, 300, 35);//user.email
        g.fillRect(115, 390, 300, 35);//user.password
        g.fillRect(165, 440, 200, 50);//sign up
        g.fillRect(165, 575, 200, 50);//sign in*/
    }
	
	public User getInformation(JButton button, JTextField nick, JTextField email, JTextField password){
		String nick_text = nick.getText();
		String email_text = email.getText();
		String password_text = password.getText();
		User user = new User(nick_text, email_text, password_text);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				/*EventQueue.invokeLater(new Runnable(){
					public void run(){
						JFrame frame;
						try {
							frame = new JFrame();
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame.setVisible(true);
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				});*/
			}
		});
		return user;
	}
}
