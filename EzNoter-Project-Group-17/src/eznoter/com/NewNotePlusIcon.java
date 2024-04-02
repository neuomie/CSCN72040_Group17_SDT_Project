package eznoter.com;
import javax.swing.*;
import java.awt.*;

public class NewNotePlusIcon {
	public void PlusIcon(JFrame mainFrame) {
		ImageIcon plusIcon = new ImageIcon("plus icon.png");
		
		Image resizedImage =  plusIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		ImageIcon resizedPlusIcon = new ImageIcon(resizedImage);
		
		JLabel plusLabel = new JLabel(resizedPlusIcon);
		
		JPanel myIconPanel = new JPanel();
		myIconPanel.setPreferredSize(new Dimension(32, 32));
		myIconPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Align to the right
        myIconPanel.add(plusLabel);
        //myIconPanel.setVisible(true);

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(myIconPanel, BorderLayout.SOUTH);	
        
		
	}
}
