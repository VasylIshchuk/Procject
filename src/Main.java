public class Main {
    public static void main(String[] args) {
        // LB 2; Task 4b
        Point point1 = new Point(0,0);
        Point point2 = new Point(250,250);
        Segment line = new Segment(point1,point2);
        Style style = new Style("pink","blue",2.0);

        Shape ellipse = new Ellipse(style,new Point(120,80),100,50);
        Shape polygon = Polygon.square(line,new Style("yellow",null,null));

        SvgScene svgScene = new SvgScene();
        svgScene.addShape(polygon);
        svgScene.addShape(ellipse);
        svgScene.saveHtml("./test.html");
    }
}