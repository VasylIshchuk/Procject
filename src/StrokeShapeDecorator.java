import java.util.Locale;

// Adds borders and their color.
// (Concrete Decorator) Implementation of a concrete decorator that adds additional functionality to our shape (concrete component(Polygon..)).
public class StrokeShapeDecorator extends ShapeDecorator {
    private String color;
    private double width;

    //    Receives the borders and their color (in ShapeDecorator), as well as the shape to which these will be applied.
    //    The shapes need to be passed in order to know where to add the new functionality.
    public StrokeShapeDecorator(Shape decoratedShape, String color, double width) {
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }

    //    This is exactly what gets added to our shape in SVG, and it is passed as "parameter".
    @Override
    public String toSvg(String parameter) {
        return super.toSvg(String.format(Locale.ENGLISH,
                "stroke=\"%s\" stroke-width=\"%f\" %s", color, width, parameter));
    }
}
