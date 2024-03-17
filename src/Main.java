public class Main {
    public static void main(String[] args) {
        // LB 2; Task 3
        Point point1 = new Point(0,100);
        Point point2 = new Point(100,102);
        Segment segment =new Segment(point1,point2);
        Style style=new Style("pink",null,2.0);
        Polygon polygon = Polygon.square(segment,style);
        SvgScene svgScene = new SvgScene();
        svgScene.addPolygon(polygon);
        svgScene.saveHtml("./test.html");
    }
}