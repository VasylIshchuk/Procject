public class ShapeDecorator implements  Shape{
    protected  Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public String toSvg(String parameter) {
       return decoratedShape.toSvg(parameter);
    }
}
