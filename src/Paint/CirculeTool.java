package Paint;

import java.awt.*;

public class CirculeTool extends DragTool
{
    public CirculeTool(Color clr, int dim)
    {
        super(clr, dim);
        strokeStyle = StrokeStyle.OPEN_OVAL;
    }
}
