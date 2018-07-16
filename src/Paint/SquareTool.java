package Paint;
import java.awt.*;

public class SquareTool extends DragTool
{
    public SquareTool(Color clr, int dim)
    {
        super(clr, dim);
        strokeStyle = StrokeStyle.OPEN_RECT;
    }
}
