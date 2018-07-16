package Paint;

import javax.swing.*;
import java.awt.*;

public abstract class ToolOptionPanel extends JPanel 
{
    Tool tool;
    Color color;
    
    public ToolOptionPanel(Tool tool)
    {
        this.tool = tool;
        setPreferredSize(new Dimension(164,256));
        setBackground(Color.gray);
    }

    public void setColor(Color clr)
    {
        color = clr;
    }
    public Color getColor()
    {
        return color; 
    }
}
