//package eznoter.com;
//import javax.swing.*;

//import java.awt.Font;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
package eznoter.com;
import javax.swing.*;
import java.awt.datatransfer.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.DataFlavor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

//CLEAN UP CODE SEMANTICS LATERR

public class MenuActionListener implements ActionListener {
	
	 //for save, undo and redo menu items
	private NotesOriginator originator =  new NotesOriginator();
	private NotesCaretaker caretaker = new NotesCaretaker();
	private JTextArea myTextArea;
	private JFrame myFrame;
	private int saveFiles = 0;
	private int currentNote = 0;
	UndoManager um = new UndoManager();

	functionEdit edit = new functionEdit(this); 


	
	    // Constructor to receive GUI instance
	public MenuActionListener(JTextArea theText, JFrame mainFrame) {
	        this.myTextArea = theText;
	        this.myFrame = mainFrame;
	    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
        switch (actionCommand) {
        	case "Share":
        		shareNote();
    			break;
    			
        	case "About":
        		About();
    			break;
    			
        	case "Save to notes app":
        		saveToApp();
    			break;
    		
            case "Cut":
                cutText();
                break;
                
            case "Copy":
                copyText();
                break;
                
            case "Paste":
                pasteText();
                break;
        		}
            }
		// TODO Auto-generated method stub
		/*String myItem = e.getActionCommand();
		
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
		else if(myItem.equals("Cut")) {
			 // add the cut code here
		}
		else if(myItem.equals("Copy")) {
			// add the copy code here
		}
		else if(myItem.equals("Paste")) {
			// add the paste code here
		*/
		
	//}
	private void copyText() {
        String selectedText = myTextArea.getSelectedText();
        if (selectedText != null) {
            StringSelection selection = new StringSelection(selectedText);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        }
    }

    private void pasteText() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable contents = clipboard.getContents(null);
            if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                String pasteData = (String) contents.getTransferData(DataFlavor.stringFlavor);
                if (pasteData != null) {
                    myTextArea.insert(pasteData, myTextArea.getCaretPosition());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	private void cutText() {
        String selectedText = myTextArea.getSelectedText();
        StringSelection selection = new StringSelection(selectedText);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        myTextArea.replaceRange("", myTextArea.getSelectionStart(), myTextArea.getSelectionEnd());
    }

    private void shareNote() {
    	JFrame shareFrame = new JFrame("Share");
		
		JLabel shareLabel1 = new JLabel("You can share files with friends!"); //make labels
		shareLabel1.setFont(new Font("Arial", Font.PLAIN, 14)); //edit font style of labels
		shareFrame.add(shareLabel1); //attach labels to window frame
		
		//resolve window frame size
		shareFrame.setSize(250,250);
		shareFrame.setVisible(true);
    }
    
    private void About() {
    	JFrame aboutFrame = new JFrame("About");
		//make labels
		JLabel aboutLabel1 = new JLabel("This Application was created by: \n");
		JLabel aboutLabel2 = new JLabel("Group 17: Drasti, Ehi, Sadiya and Umang \n");
		JLabel aboutLabel3 = new JLabel("Do not Copyright!!!");
		
		//edit font style of labels
		aboutLabel1.setFont(new Font("Arial", Font.PLAIN, 14));
		aboutLabel2.setFont(new Font("Arial", Font.PLAIN, 14));
		aboutLabel3.setFont(new Font("Arial", Font.PLAIN, 14));
		
		//attach labels to window frame
		aboutFrame.add(aboutLabel1);
		aboutFrame.add(aboutLabel2);
		aboutFrame.add(aboutLabel3);
		
		//resolve window frame size
		aboutFrame.setSize(400,400);
		aboutFrame.setVisible(true);
    }
    
    private void saveToApp() {
    	String textInTextArea = myTextArea.getText();
		
		originator.setNote(textInTextArea);
		caretaker.addMemento(originator.storeInMemento());
		saveFiles++;
		currentNote++;
    }
}
