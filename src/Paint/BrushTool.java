package Paint;
import Paint.StrokeStyle;
import java.awt.*;

public class BrushTool extends PencilTool
{
    public BrushTool(Color clr, int dim, StrokeStyle style)
    {
        super(clr, dim);
        strokeStyle = style;
        element = new BrushElement();
    }
    @Override
    public void drawElement(Graphics g)
    {
        element.update(g);
    }
}
