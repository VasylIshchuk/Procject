
import java.util.Locale;

public class Polygon {
    private Point[] points;
    Style style;
    public Polygon(Point[] points, Style style) {
        this.points=points;
        this.style=style;
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
}
