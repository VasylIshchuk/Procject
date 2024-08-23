import java.util.Locale;

// Completely fills the shape with a color.
// (Concrete Decorator) Implementation of a concrete decorator that adds additional functionality to our shape (concrete component(Polygon..)).
public class SolidFillShapeDecorator extends ShapeDecorator {
    private String color;

    //    Receives a shape and the color (in ShapeDecorator) with which it should be filled.
    public SolidFillShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    //    This is exactly what gets added to our shape in SVG, and it is passed as "parameter".
    @Override
    public String toSvg(String parameter) {
        return super.toSvg(
                String.format(Locale.ENGLISH, "fill=\"%s\" %s", color, parameter));
    }
}
