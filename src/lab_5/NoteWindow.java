package lab_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NoteWindow extends JDialog {
    private JTextArea textArea;
    private static int noteCounter = 1;
    private final String fontName = "Arial";
    private final int fontSize = 18;
    public NoteWindow(JFrame frame) {
        super(frame, "Заметка" + noteCounter++, false);
        setSize(300, 200);
        setLocationRelativeTo(frame);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        createTextPanel(fontName, fontSize);
    }

    public void createTextPanel(String fontName, int fontSize) {
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setFont(new Font(fontName, Font.PLAIN, fontSize));
        getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

}
