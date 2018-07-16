package Paint;

import java.awt.*;
import javax.swing.*;

public class ColorPanel extends JPanel
{
    public ColorPanel(Color clr)
    {
        setBackground(clr);
    }

    public ColorPanel(Color clr, int x, int y)
    {
        setBackground(clr);
        setPreferredSize(new Dimension(x, y));
    }
}
