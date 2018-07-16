package Paint;

import Paint.PaintTool;
import java.awt.*;

public class PencilTool extends PaintTool
{
    public PencilTool(Color clr, int dim)
    {
        super(clr, dim);
        element = new PencilElement();
        strokeWidth = dim;
        isDrawing   = false;
    }
    @Override
    public void drawElement(Graphics g)
    {
        element.update(g);
    }
}
