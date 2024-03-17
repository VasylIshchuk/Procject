
import java.util.Locale;

public class Polygon {
    private Point[] points;
    Style style;
    public Polygon(Point[] points, Style style) {
        this.points=points;
        this.style=style;
    }
    public Polygon(int count, Style style) {
        this.points=new Point[count];
        this.style=style;
    }
    public void setPoints(Point[] points) {
        this.points = points;
    }
    public void setPoint(int index,Point points) {
        this.points[index] = points;
    }

    public void print(){
        for(Point point : points) {
            System.out.println(point.x +" "+ point.y );
        }
    }
    public String toSvg(){
        String pointsString = "";
        for(Point point : points){
            pointsString += point.x +","+point.y+" ";
        }
        return String.format(Locale.ENGLISH,"<polygon points=\"%s\"%s />",pointsString,style.toSvg());
    }
    public static Polygon square(Segment line, Style style){
        double x=(line.getPoint1().x+ line.getPoint2().x)/2;
        double y=(line.getPoint1().y+ line.getPoint2().y)/2;
        Point center = new Point(x,y);
        Segment [] segments = Segment.perpendicular(line,center,line.lengthSection()/2);

        Polygon square = new Polygon(4,style);
        square.setPoint(0,line.getPoint1());
        square.setPoint(1,segments[0].getPoint2());
        square.setPoint(2,line.getPoint2());
        square.setPoint(3,segments[1].getPoint2());
        return square;
    }
}
