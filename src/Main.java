public class Main {
    public static void main(String[] args) {
        // LB 2; Task 1
        Point point1=new Point(1,3);
        Point point2=new Point(3,1);

        Style style=new Style("red","blue",2.0);
        Polygon polygon =new Polygon(new Point[]{point1,point2},style);
        System.out.println(polygon.toSvg());

        Style style1=new Style(null,null,2.0);
        Polygon polygon1 =new Polygon(new Point[]{point1,point2},style1);
        System.out.println(polygon1.toSvg());
    }
}