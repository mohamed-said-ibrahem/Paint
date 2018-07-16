package Paint;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.event.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class PaintMenuBar extends JMenuBar
{
    JMenu file;
        JMenuItem quit;
        JMenuItem newSketch;
        JMenuItem openSketch;
        JMenuItem saveSketch;
    PaintMenuBar()
    {
        PaintMenuBar.ItemHandler s = new PaintMenuBar.ItemHandler();

        file   = new JMenu("File");

        newSketch = new JMenuItem("New");
        openSketch = new JMenuItem("Load");
        saveSketch = new JMenuItem("Save");
        quit = new JMenuItem("Quit");

        newSketch.addActionListener(s);
            openSketch.addActionListener(s);
            saveSketch.addActionListener(s);
            quit.addActionListener(s);

        file.add(newSketch);
        file.addSeparator();
        file.add(openSketch);
        file.addSeparator();
        file.add(saveSketch);
        file.addSeparator();
        file.add(quit);
        add(file);
    }

    private class ItemHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if ( event.getSource() == quit)
            {
                Main.paint.dispose();
                System.exit(0);
            }

            if ( event.getSource() == newSketch )
            {
                Main.paint.drawPanel.elements = new ArrayList();
                Main.paint.drawPanel.elements.add(new FillerElement(Color.white));
            }

            if ( event.getSource() == saveSketch )
            {
                Main.paint.saveFile();
            }

            if ( event.getSource() == openSketch )
            {
                File fileName = Main.paint.getFileName();
                Main.paint.loadFile(fileName);
                Main.paint.loadElementsFromFile();
                Main.paint.closeFile();
            }
            Main.paint.repaint();
            setFocusable(false);
        }
    }
}
