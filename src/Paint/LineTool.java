package Paint;

import java.awt.*;

public class LineTool extends DragTool
{
    public LineTool(Color clr, int dim, StrokeStyle style)
    {
        super(clr, dim);
        strokeStyle = style;
    }
}