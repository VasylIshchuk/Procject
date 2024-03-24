public class Main {
    public static void main(String[] args) {

        Vec2 point1 = new Vec2(0,100);
        Vec2 point2 = new Vec2(100,102);
        Vec2 point3 = new Vec2(50,50);

        Shape ellipse = new Ellipse(100,50,new Vec2(120,80));
        Shape polygon = new Polygon(new Vec2[]{point1,point2,point3});

        //1 method
        Shape strokeAndSolidFilledPolygon = new StrokeShapeDecorator(new SolidFillShapeDecorator(polygon, "violet"), "black", 3);
        //the order of decorators is important.

        //2 method
        Shape strokeAndSolidFilledEllipse =new SolidFillShapeDecorator(ellipse,"yellow");
        strokeAndSolidFilledEllipse =new StrokeShapeDecorator(strokeAndSolidFilledEllipse,"blue",5);

        SvgScene svgScene = new SvgScene();
        svgScene.addShape(strokeAndSolidFilledEllipse);
        svgScene.addShape(strokeAndSolidFilledPolygon);
        svgScene.saveHtml("./test.html");
    }
}