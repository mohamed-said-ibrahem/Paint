package Paint;

import Paint.StrokeStyle;
import java.awt.*;

public class EraserTool extends BrushTool
{
    EraserElement element; 
    public EraserTool(Color clr, int dim, StrokeStyle style)
    {
        super(clr, dim, style);
    }
}
