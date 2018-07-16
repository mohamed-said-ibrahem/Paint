package Paint;

import java.awt.*;

public class RoundRectTool extends RectangleTool
{
    public RoundRectTool (Color clr, int dim)
    {
        super(clr, dim);
        strokeStyle = StrokeStyle.OPEN_ROUND_RECT;
    }
}
