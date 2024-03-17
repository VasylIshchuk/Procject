
import java.util.Locale;
public class Segment {
    private Point point1, point2;
    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public Point getPoint1() {
        return point1;
    }
    public Point getPoint2() {
        return point2;
    }
    public double lengthSection() {
        double resultX = point1.x - point2.x;
        double resultY = point1.y - point2.y;
        return Math.sqrt(resultX * resultX + resultY * resultY);//return Math.hypot(p1.x - p2.x, p1.y - p2.y);
    }
    public String toSvg() {
        return String.format(Locale.ENGLISH,"<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\"" +
                " style=\"stoke:blue,stoke-width:2\" />"
                , point1.x, point1.y, point2.x, point2.y);
    }
    public static Segment[] perpendicular(Segment line, Point point, double r) {
        double a;
        a = (line.point1.y - line.point2.y) / (line.point1.x - line.point2.x);//y=kx+b; y=ax+b; a = (Y1 - Y2) / (X1 - X2)
        double b;
        a=-1/a;//In mathematics and programming, when we define the slope (a) for a line, its inverse, changes sign and becomes perpendicular.
        b=point.y-a*point.x;//y=ax+b; b=y-a*x

        double x0 = point.x;
        double y0 = point.y;

        double root = Math.sqrt(-y0*y0+(2*a*x0+2*b)*y0-a*a*x0*x0-2*a*b*x0+(a*a+1)*r*r-b*b);
        double x1 = -(root-a*y0-x0+a*b)/(a*a+1);
        double y1 = -(a*root-a*a*y0-a*x0-b)/(a*a+1);
        double x2 = (root+a*y0+x0-a*b)/(a*a+1);
        double y2 = (a*root+a*a*y0+a*x0+b)/(a*a+1);

        return new Segment[]{new Segment(point, new Point(x1,y1)), new Segment(point, new Point(x2,y2))};
    }
}