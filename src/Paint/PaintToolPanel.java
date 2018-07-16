package Paint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintToolPanel extends JPanel
{
    protected ToolButton[] buttons;
    public ToolOptionPanel toolOptionPanel; 
    public PaintToolPanel(ToolOptionPanel toolOptionPanel)
    {
        setPreferredSize(new Dimension(200,0));
        setLayout(new BorderLayout(7,7));
        JPanel tools =  new JPanel();
        tools.setLayout(new GridLayout(12,0));
        tools.setPreferredSize(new Dimension(100,350));
        this.toolOptionPanel = toolOptionPanel;
        buttons = new ToolButton[12];
        buttons[0] = new ToolButton("Brush", Tool.BRUSH);
        buttons[1] = new ToolButton("line", Tool.LINE);
        buttons[2] = new ToolButton("Circule", Tool.CIRCULE);
        buttons[3] = new ToolButton("oval", Tool.OVAL);
        buttons[4] = new ToolButton("polygon", Tool.ROUND_RECT);
        buttons[5] = new ToolButton("rectangle", Tool.RECTANGLE);
        buttons[6] = new ToolButton("Square", Tool.SQUARE);
        buttons[7] = new ToolButton("Eraser", Tool.ERASER);
        buttons[8] = new ToolButton("Paint Bucket", Tool.FILLER);
        buttons[9] = new ToolButton("Color Picker", Tool.PICKER);
        buttons[10] = new ToolButton("Shadow",Tool.AIRBRUSH);
        buttons[11] = new ToolButton("Triangle",Tool.AIRBRUSH);
        for(int i=0; i<buttons.length; i++)
        {
        	tools.add(buttons[i]);
        }
        add(tools, BorderLayout.NORTH);
        add(toolOptionPanel, BorderLayout.SOUTH);
    }
    public void setToolOptionPanel (ToolOptionPanel panel)
    {
        this.remove(toolOptionPanel);
        toolOptionPanel = panel;
        add(toolOptionPanel, BorderLayout.SOUTH);
        revalidate();
        repaint();
    }
}
