package Paint;

import Paint.Tool;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList; 

public class ColorPicker extends JPanel
{
    protected ColorOptionBox[] colorOptions; 
    protected ArrayList points;
    protected JPanel currentClrPanel;
    protected Color[] colors;
    protected Color color;
    public ColorPicker()
    {
        setBackground(Color.darkGray);
        setPreferredSize(new Dimension(90,90));
        setLayout(new BorderLayout());
        Color[] colors = {
              Color.white,Color.black, Color.red,
              Color.blue,Color.green,Color.magenta,Color.orange,
              Color.lightGray,Color.gray,
              Color.getHSBColor(56,25, 5),Color.cyan,Color.pink
              };
        color  = Color.black;
        currentClrPanel = new JPanel();
        currentClrPanel.setBackground(Color.white);
        currentClrPanel.setPreferredSize(new Dimension(92,92));
        currentClrPanel.addMouseListener(
            new MouseAdapter()
            {
                @Override
                public void mousePressed(MouseEvent event)
                {
                    if (Main.paint.drawPanel.getTool() != Tool.ERASER)
                    {
                        currentClrPanel.setBackground(
                                    JColorChooser.showDialog( Main.paint, "COLORS",
                                                         Main.paint.drawPanel.brushColor));
                        color = currentClrPanel.getBackground();
                        Main.paint.drawPanel.tool.setColor(currentClrPanel.getBackground());
                        Main.paint.drawPanel.setBrushColor(color);
                    }
                }
            }
        );
        JPanel colorGrid = new JPanel();
        colorGrid.setBackground(Color.darkGray);
        colorGrid.setLayout(new GridLayout(2, 16, 3, 3));
        colorOptions = new ColorOptionBox[colors.length];
        for(int i=0; i<colorOptions.length; i++)
        {
            colorOptions[i] = new ColorOptionBox(colors[i]);
            colorGrid.add(colorOptions[i]);
        }
        ColorPanel col1 = new ColorPanel(Color.darkGray);
        col1.setLayout(new BorderLayout(6, 6));
        col1.add(currentClrPanel, BorderLayout.WEST);
        col1.add(colorGrid, BorderLayout.CENTER);

        JPanel col2 = new JPanel();
        col2.setLayout(new BorderLayout());
        col2.add(new ColorPanel(Color.darkGray), BorderLayout.WEST);
        col2.add(new ColorPanel(Color.darkGray), BorderLayout.EAST);
        col2.add(new ColorPanel(Color.darkGray), BorderLayout.SOUTH);
        col2.add(new ColorPanel(Color.darkGray), BorderLayout.NORTH);

        col2.add(col1, BorderLayout.CENTER);
        add(col2, BorderLayout.CENTER);
    }
    public void deselectAll()
    {
        for(int i=0; i<colorOptions.length; i++)
        {
            colorOptions[i].selected = false;
        }
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}
