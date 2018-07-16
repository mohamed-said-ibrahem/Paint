package Paint;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class PaintApplication extends JFrame
{
    public ObjectOutputStream output;
    public ObjectInputStream input;
    public DrawPanel drawPanel;
    protected PaintMenuBar menuBar; 
    protected ColorPicker colorPicker;
    public PaintToolPanel paintTools;
    public PaintApplication()
    {
        this.
        setSize(1750, 1000);
        setTitle("Paint");
        setLayout(new BorderLayout());
        drawPanel   = new DrawPanel();
        menuBar     = new PaintMenuBar();
        colorPicker = new ColorPicker();
        paintTools  = new PaintToolPanel(new PencilToolPanel(Tool.PENCIL, 1));
		add(menuBar,    BorderLayout.NORTH);
        add(colorPicker,BorderLayout.SOUTH);
        add(paintTools, BorderLayout.EAST);
        add(new JScrollPane(drawPanel),  BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        synchronizeStartingColor();
    }
    
    public void synchronizeStartingColor()
    {
        colorPicker.currentClrPanel.setBackground(Color.black);
        colorPicker.color = colorPicker.currentClrPanel.getBackground();
        drawPanel.tool.setColor(colorPicker.currentClrPanel.getBackground());
        drawPanel.setBrushColor(colorPicker.color);
    }

    public File getFileName()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setCurrentDirectory(new File("/Users/stevevitali/Desktop"));

        int result = fileChooser.showOpenDialog(this);

        File fileName = fileChooser.getSelectedFile();

        return fileName;
    }

    public void writeSketchToFile(File fileName)
    {
       try
        {
            for (int i=0; i<drawPanel.elements.size(); i++)
            {
                PaintElement elem = (PaintElement) drawPanel.elements.get(i);
                output.writeObject(elem);
            }
        }
        catch ( IOException exception )
        {
            System.err.println("Error writing to file.");
            return;
        }
    }

    public void loadElementsFromFile()
    {
        
        try
        {
            drawPanel.elements.clear();
            while(true)
            {
                drawPanel.elements.add(input.readObject());
            }
        }
        catch (IOException exception)
        {
            return;
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            System.err.println("Unable to create object.");
        }
    }

    public void loadFile(File fileName)
    {
        try
        {
            input = new ObjectInputStream(new FileInputStream(fileName));
        }
        catch(IOException ioException)
        {
            System.err.println("Error loading file: "+fileName);
            return;
        }
    }

    public void openFile(File fileName)
    {
        try
        {
            output = new ObjectOutputStream(new FileOutputStream(fileName));
        }
        catch(IOException ioException)
        {
            System.err.println("Error loading file: "+fileName);
            return;
        }
    }

    public void saveFile()
    {
        try
        {
            JFileChooser chooseDirec = new JFileChooser();
            chooseDirec.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooseDirec.showSaveDialog(Main.paint);
            File file = chooseDirec.getSelectedFile();
            File file2 = chooseDirec.getSelectedFile();
            file = new File(file+".JSON");
            file2 = new File(file2+".XML");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2));
            bufferedWriter.close();
            bufferedWriter2.close();
            openFile(file);
            openFile(file2);
            writeSketchToFile(file);
            writeSketchToFile(file2);
            closeFile();
        }
        catch (IOException exception)
        {
            System.err.println("Error saving to new file.");
        }
    }

    public void closeFile()
    {
        try
        {
            if (output != null)
                output.close();
        }
        catch (IOException exception)
        {
            System.err.println("Error closing file");
            System.exit(1);
        }
    }
}
