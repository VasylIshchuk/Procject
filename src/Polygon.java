
import java.util.Locale;

public class Polygon {
    private Point[] points;
    public Polygon(Point[] otherPoints) {
        ///this.points = points;
        this.points=new Point[otherPoints.length];
        for (int i=0;i<otherPoints.length;++i){
            this.points[i]=new Point(otherPoints[i].x,otherPoints[i].y);//deep copy of the object
        }
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
        return String.format(Locale.ENGLISH,"<line points=\"%s\" " +
                "style=\"stoke:blue,stoke-width:2\" />",pointsString);
    }
}
