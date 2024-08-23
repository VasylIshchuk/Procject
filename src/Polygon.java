import java.util.Locale;

public class Polygon implements Shape {
    private Vec2[] points;//private  Style style;

    //    Constructor. Defines the points for a polygon using a table of points.
    public Polygon(Vec2[] points) { //, Style style
        this.points = points; //this.style=style;
    }

    //    Constructor. Initializes the "points" table and sets the required number of points to be used later for creating a square.
    public Polygon(int count) { //, Style style
        this.points = new Vec2[count];//this.style=style;
    }

    //    Initializes a single cell of the "points" table, used for creating a square.
    public void setPoint(int index, Vec2 points) {
        this.points[index] = points;
    }

    //    Creates an SVG for a polygon.
    @Override
    public String toSvg(String parameter) {
        StringBuilder pointsString = new StringBuilder();
        for (Vec2 point : points) {
            pointsString.append(point.x).append(",").append(point.y).append(" ");
        }
        //        Make sure to add the "parameter" at the end, as this is where decorators (like solid, stroke, etc.) are appended.
        return String.format(Locale.ENGLISH, "\t<polygon points=\"%s\" %s/>", pointsString, parameter);//style.toSvg()
    }

    //    Creates an SVG square using a diagonal.
    public static Polygon square(Segment diagonal) { //, Style style
        double x = (diagonal.getPoint1().x + diagonal.getPoint2().x) / 2;
        double y = (diagonal.getPoint1().y + diagonal.getPoint2().y) / 2;
        Vec2 center = new Vec2(x, y);
        Segment[] segments = Segment.perpendicular(diagonal, center, diagonal.lengthSection() / 2);

        Polygon square = new Polygon(4);//style
        square.setPoint(0, diagonal.getPoint1());
        square.setPoint(1, segments[0].getPoint2());
        square.setPoint(2, diagonal.getPoint2());
        square.setPoint(3, segments[1].getPoint2());
        return square;
    }
}
