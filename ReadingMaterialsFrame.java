package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class ReadingMaterialsFrame extends JFrame{
	public ReadingMaterialsFrame(int level) throws ClassNotFoundException{
		setSize(550,730);
		ReadingMaterialsPanel panel = new ReadingMaterialsPanel(level);
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane).setBounds(0, 0, 550, 730);;
	}
}

class ReadingMaterialsPanel extends JPanel{
	String filename_level1[] = {"Christmas Cards", "Hit the Floor!", "Learning foreign languages", "The jackal and the elephant", "Traveling around the USA","Susan and the Secret Code","Mushrooms","Johnny Appleseed","The fountain of youth","Big Ben"};
	String filename_level2[] = {"London","Keep Fit","Higher Education In The USA","Football","The Sahara","Chinese New Year","Britain's Universities","The Princess and the Pea","The Pack Of Biscuits","The Christmas Presents"};
	String filename_level3[] = {"Golf","Electricity","Basketball","Abraham Lincoln","Isaac Newton","The money","The Silver Shilling","Year�s Shortest Day","Do We Need Meat","Michelangelo"};
	int level, yt,yl;
	public static Reading_Text newframe;

	public ReadingMaterialsPanel(int level) throws ClassNotFoundException{
		
		setLayout(null);
		setPreferredSize(new Dimension(550, 2840));
		setBackground(new Color(123,31,31));
		yt = 60;//20
		yl = 20;
		if (level==1){
			for (int i=0; i<filename_level1.length; i++){
				addText(filename_level1[i],yt,yl);
				yt = yt+280;
				yl = yl+280;
			}
		}
		if (level==2){
			for (int i=0; i<filename_level2.length; i++){
				addText(filename_level2[i],yt,yl);
				yt = yt+280;
				yl = yl+280;
			}
		}
		if (level==3){
			for (int i=0; i<filename_level3.length; i++){
				addText(filename_level3[i],yt,yl); 
				yt = yt+280;
				yl = yl+280;
			}
		}
	}
	
	public void addText(String filename, int yt,int yl) throws ClassNotFoundException{
		JLabel labelTitle = new JLabel(filename);
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelTitle.setBackground(Color.white);
		add(labelTitle).setBounds(0,yl+10,550,40);
		
		String text = reading("Text level 1/"+filename+".txt");
		JTextArea textArea = new JTextArea(text);
        textArea.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
		add(textArea).setBounds(45,yt+25,440,150);
        
		ImageIcon icon = new ImageIcon("Image/next.png");
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		JButton button = new JButton(icon);
		button.setBackground(new Color(210,149,149));
		add(button).setBounds(460,yl+225,30,30);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				newframe = new Reading_Text(text, filename);
				newframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				newframe.setVisible(true);
			}
		});
	}
	
	public String reading (String filename) throws ClassNotFoundException{
		String text = "";
		try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
            	text = text + line;
                line = reader.readLine();
            }
            reader.close();
        } 
		catch (FileNotFoundException e) {} 
		catch (IOException e) {}
		return text;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int y = 20;
		for (int i=0; i<10; i++){
			g.setColor(Color.WHITE);
			g.fillRect(20, y, 480, 260);
			g.setColor(new Color(210,149,149));
			g.fillRect(20, y+220, 480, 40);
			y = y+280;
		}
	}
}