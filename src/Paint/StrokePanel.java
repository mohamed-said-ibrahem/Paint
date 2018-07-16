package Paint;

import Paint.StrokeStyle;
import Paint.Main;

import java.awt.*;
import javax.swing.*;

public class StrokePanel extends JPanel
{
    public StrokeStyle style;

    public StrokePanel()
    {
        setPreferredSize(new Dimension(84, 84));
        style = StrokeStyle.DOT_RECT;
    }
    public void setStyle(StrokeStyle style)
    {
        this.style = style; 
    }
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Main.paint.drawPanel.tool.getColor());

        if ( ( style == StrokeStyle.DOT_RECT) || (style == StrokeStyle.SQUARE) ||
             ( style == StrokeStyle.LINE)     || (style == StrokeStyle.FILL_RECT ))
        {
            g.fillRect(getWidth ()/2-Main.paint.drawPanel.tool.getStroke()/2,
                   getHeight()/2-Main.paint.drawPanel.tool.getStroke()/2,
                                 Main.paint.drawPanel.tool.getStroke(),
                                 Main.paint.drawPanel.tool.getStroke());

            g.setColor(Color.black);
            g.drawRect(getWidth ()/2-Main.paint.drawPanel.tool.getStroke()/2,
                   getHeight()/2-Main.paint.drawPanel.tool.getStroke()/2,
                                 Main.paint.drawPanel.tool.getStroke(),
                                 Main.paint.drawPanel.tool.getStroke());
        }
        if ( (style == StrokeStyle.DOT_CIRC)  ||
             (style == StrokeStyle.FILL_OVAL)||(style == StrokeStyle.CIRCLE ) )
        {
            g.fillOval(getWidth ()/2-Main.paint.drawPanel.tool.getStroke()/2,
                   getHeight()/2-Main.paint.drawPanel.tool.getStroke()/2,
                                 Main.paint.drawPanel.tool.getStroke(),
                                 Main.paint.drawPanel.tool.getStroke());

            g.setColor(Color.black);
            g.drawOval(getWidth ()/2-Main.paint.drawPanel.tool.getStroke()/2,
                   getHeight()/2-Main.paint.drawPanel.tool.getStroke()/2,
                                 Main.paint.drawPanel.tool.getStroke(),
                                 Main.paint.drawPanel.tool.getStroke());
        }
    }
}