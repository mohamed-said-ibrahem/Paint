package Paint;

import java.awt.*;

public class RectangleTool extends DragTool
{
    public RectangleTool(Color clr, int dim)
    {
        super(clr, dim);
        strokeStyle = StrokeStyle.OPEN_RECT;
    }
}
