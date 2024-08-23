import java.util.Locale;

public class Ellipse implements Shape {
    private Vec2 center;
    private double rx, ry;//private Style style;

    //    Constructor. Defines the points for an ellipse (radius along x and y, and the center).
    public Ellipse(double rx, double ry, Vec2 center) { //, Style style
        this.rx = rx;
        this.ry = ry;
        this.center = center;//this.style=style;
    }

    //    Creates an SVG for an ellipse.
    @Override
    public String toSvg(String parameter) {
        return String.format(Locale.ENGLISH, "\t<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\"%s/>"
                , rx, ry, center.x, center.y, parameter);//style.toSvg()
        //    Make sure to add the "parameter" at the end, as this is where decorators (like solid, stroke, etc.) are appended.
    }
}
