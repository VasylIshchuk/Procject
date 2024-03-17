public class Main {
    public static void main(String[] args) {

        // LB 3; Task 0
        Vec2 point1 = new Vec2(0,0);
        Vec2 point2 = new Vec2(250,250);
        Segment line = new Segment(point1,point2);
        Style style = new Style("pink","blue",2.0);

        Shape ellipse = new Ellipse(style,new Vec2(120,80),100,50);
        Shape polygon = Polygon.square(line,new Style("yellow",null,null));

        SvgScene svgScene = new SvgScene();
        svgScene.addShape(polygon);
        svgScene.addShape(ellipse);
        svgScene.saveHtml("./test.html");
    }
}