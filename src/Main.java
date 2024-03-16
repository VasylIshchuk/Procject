public class Main {
    public static void main(String[] args) {
        // LB 2; Task 2
        Point point1 = new Point(100,0);
        Point point2 = new Point(50,100);
        Point point3 = new Point(150,100);
        Style style1=new Style("pink",null,2.0);
        Polygon polygon1 =new Polygon(new Point[]{point1,point2,point3},style1);
        SvgScene svgScene = new SvgScene();
        svgScene.addPolygon(polygon1);
        svgScene.saveHtml("./test.html");
    }
}