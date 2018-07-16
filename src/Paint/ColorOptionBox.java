package Paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Dimension;

public class ColorOptionBox extends JPanel
{
    Color   color;
    boolean selected; 
    public ColorOptionBox(Color clr)
    {
        color = clr; 
        selected = false;
        setBackground(color);
        setPreferredSize(new Dimension(1000,1000));
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
    }
    private class MouseHandler extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent event) 
        {
            Main.paint.colorPicker.deselectAll();
            selected = true;
            Main.paint.drawPanel.setBrushColor(color);
            Main.paint.colorPicker.currentClrPanel.setBackground(color);
            Main.paint.repaint();
        }
    }
}
