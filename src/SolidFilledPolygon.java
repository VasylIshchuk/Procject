import java.awt.*;
import java.util.Locale;

public class SolidFilledPolygon extends Polygon{
    private String color;
    public SolidFilledPolygon(Vec2[] points, String color) {
        super(points, new Style("blue","black",5.0));
        this.color=color;
    }

    @Override
    public String toSvg(String parameter) {
        return super.toSvg(
                String.format(Locale.ENGLISH,"fill=\"%s\" %s",color,parameter));
    }
}
