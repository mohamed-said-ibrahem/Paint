package Paint;

import java.awt.*;

public class OvalTool extends DragTool
{
    public OvalTool(Color clr, int dim)
    {
        super(clr, dim);
        strokeStyle = StrokeStyle.OPEN_OVAL;
    }
}
