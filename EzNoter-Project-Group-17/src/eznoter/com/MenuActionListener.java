package eznoter.com;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//CLEAN UP CODE SEMANTICS LATERR

public class MenuActionListener implements ActionListener {
	
	 //for save, undo and redo menu items
	private NotesOriginator originator =  new NotesOriginator();
	private NotesCaretaker caretaker = new NotesCaretaker();
	private JTextArea myTextArea;
	private JFrame myFrame;
	private int saveFiles = 0;
	private int currentNote = 0;

	    // Constructor to receive GUI instance
	public MenuActionListener(JTextArea theText, JFrame mainFrame) {
	        this.myTextArea = theText;
	        this.myFrame = mainFrame;
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String myItem = e.getActionCommand();
		
		if(myItem.equals("Share")) {
			JFrame shareFrame = new JFrame("Share");
			
			JLabel shareLabel1 = new JLabel("You can share files with friends!"); //make labels
			shareLabel1.setFont(new Font("Arial", Font.PLAIN, 14)); //edit font style of labels
			shareFrame.add(shareLabel1); //attach labels to window frame
			
			//resolve window frame size
			shareFrame.setSize(250,250);
			shareFrame.setVisible(true);
		}
		
		else if(myItem.equals("About")) {
			JFrame aboutFrame = new JFrame("About");
			//make labels
			JLabel aboutLabel1 = new JLabel("This Application was created by: \nGroup 17: Drasti, Ehi, Sadiya and Umang \nDo not Copyright!!!");
//			JLabel aboutLabel2 = new JLabel("");
//			JLabel aboutLabel3 = new JLabel("");
			
			//edit font style of labels
			aboutLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
//			aboutLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
//			aboutLabel3.setFont(new Font("Arial", Font.PLAIN, 14));
			
			//attach labels to window frame
			aboutFrame.add(aboutLabel1);
//			aboutFrame.add(aboutLabel2);
//			aboutFrame.add(aboutLabel3);
			
			//resolve window frame size
			aboutFrame.setSize(400,400);
			aboutFrame.setVisible(true);
		}
		
		else if(myItem.equals("Save to notes app")) {
			String textInTextArea = myTextArea.getText();
			
			originator.setNote(textInTextArea);
			caretaker.addMemento(originator.storeInMemento());
			saveFiles++;
			currentNote++;
		}
		
		else if(myItem.equals("Undo")) {
			if (currentNote >= 1) {
				String prevText = originator.restoreFromMemento(caretaker.getMemento(currentNote));
				myTextArea.setText(prevText);
			}
				
		}
		
	}
	
}
