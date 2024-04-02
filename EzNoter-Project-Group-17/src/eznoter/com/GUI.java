package eznoter.com;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI {
    JFrame window;
    JTextArea textArea;
    JMenuBar myMenuBar;
    UndoManager undoManager = new UndoManager();
    
    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        window.setVisible(true);
    }

    private void createWindow() {
        window = new JFrame("EZ Noter");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createTextArea() {
        textArea = new JTextArea();
        textArea.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));
        JScrollPane scrollPane = new JScrollPane(textArea);
        window.add(scrollPane);
    }

    private void createMenuBar() {
        myMenuBar = new JMenuBar();
        
        //File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        newItem.addActionListener(e -> createNewFile());
        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());

        //Edit Menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem undoItem = new JMenuItem("Undo");
        JMenuItem redoItem = new JMenuItem("Redo");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem pasteItem = new JMenuItem("Paste");
        editMenu.add(undoItem);
        editMenu.add(redoItem);
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);
        undoItem.addActionListener(e -> undo());
        redoItem.addActionListener(e -> redo());
        copyItem.addActionListener(e -> copyText());
        cutItem.addActionListener(e -> cutText());
        pasteItem.addActionListener(e -> pasteText());

        //Save menu
        JMenu saveMenu = new JMenu("Save");
        JMenuItem saveAsItem = new JMenuItem("Save As...");
        saveMenu.add(saveAsItem);
        saveAsItem.addActionListener(e -> saveAs());

        // Add all JMenu items to the JMenuBar
        myMenuBar.add(fileMenu);
        myMenuBar.add(editMenu);
        myMenuBar.add(saveMenu); 

        
        window.setJMenuBar(myMenuBar);
    }


    private void createNewFile() {
        // Implementation here
    }

    private void openFile() {
        // Implementation here
    }

    private void saveFile() {
        // Implementation here
    }

    private void saveAs() {
        // Implementation here
    }
    
    private void copyText() {
        String selectedText = textArea.getSelectedText();
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
                    textArea.insert(pasteData, textArea.getCaretPosition());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	private void cutText() {
        String selectedText = textArea.getSelectedText();
        StringSelection selection = new StringSelection(selectedText);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
    }
	
    private void undo() {
        if (undoManager.canUndo()) {
        	undoManager.undo();
        }
    }

    private void redo() {
        if (undoManager.canRedo()) {
        	undoManager.redo();
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}

