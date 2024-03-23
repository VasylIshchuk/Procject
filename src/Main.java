public class Main {
    public static void main(String[] args) {
        // LB 3; Task 2
        Vec2 point1 = new Vec2(0,100);
        Vec2 point2 = new Vec2(100,102);
        Vec2 point3 = new Vec2(50,50);
        Style style = new Style("pink","blue",2.0);

        Shape ellipse = new Ellipse(100,50,new Vec2(120,80),style);
        Shape polygon = new Polygon(new Vec2[]{point1,point2,point3},style);
        SolidFillShapeDecorator solidFilledPolygon =new SolidFillShapeDecorator(polygon,"violet");
        SolidFillShapeDecorator solidFilledEllipse =new SolidFillShapeDecorator(ellipse,"yellow");

        SvgScene svgScene = new SvgScene();
        svgScene.addShape(solidFilledEllipse);
        svgScene.addShape(solidFilledPolygon);
        svgScene.saveHtml("./test.html");
    }
}