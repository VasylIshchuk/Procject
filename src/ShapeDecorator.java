//This is a mediator decorator that acts between the (concrete decorator) and our shape (concrete component).
public class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }
    //    It accepts the shape to which additional functionality from the (concrete decorator (SolidFillShapeDecorator...)) will be added,
    //    and thereby passes this functionality to our shape (concrete component(Polygon..)).
    @Override
    public String toSvg(String parameter) {
        return decoratedShape.toSvg(parameter);
    }
}
