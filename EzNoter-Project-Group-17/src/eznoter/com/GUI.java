package eznoter.com;
import javax.swing.*;

public class GUI {
	private JFrame jframe;
	private JMenuBar myMenuBar;
	private JMenu fileMenu;
	private JMenuItem share;
	private JMenuItem about;
	private JMenu saveMenu;
	private JMenuItem saveToApp;
	private JMenu editMenu;
	private JMenuItem undo;
	private JMenuItem redo;
	private JMenuItem cut;
	private JMenuItem copy;
	
	public GUI() {

		jframe = new JFrame("EZ Noter");
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//menu bar
		myMenuBar = new JMenuBar();
		
		//File menu display implementation
		fileMenu = new JMenu("File");
		//file menu children - implement display features for about and share
		share = new JMenuItem("Share");
		about = new JMenuItem("About"); 
		//connect children to file menu
		fileMenu.add(share);
		fileMenu.add(about);
		
		//Save Menu Display Implementation
		saveMenu = new JMenu("Save");
		//save menu children - implement save to application
		saveToApp = new JMenuItem("Save to notes app");
		//connect children to save menu
		saveMenu.add(saveToApp);
		
		//Edit menu display implementation
		editMenu = new JMenu("Edit");
		//edit menu children - implement all the children
		undo = new JMenuItem("Undo");
		redo = new JMenuItem("Redo");
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		//connect children to edit menu
		editMenu.add(undo);
		editMenu.add(redo);
		editMenu.add(cut);
		editMenu.add(copy);
		
		//connect file menu to menu bar
		myMenuBar.add(fileMenu);
		//connect save menu to menu bar
		myMenuBar.add(saveMenu);
		//connect settings menu to menu bar
		myMenuBar.add(editMenu);
		
		jframe.setJMenuBar(myMenuBar);
		jframe.setSize(900,700);
		jframe.setVisible(true);
	}
	
	
}
