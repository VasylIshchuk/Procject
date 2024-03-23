import java.util.Locale;

public class Ellipse implements Shape{
    private Vec2 center;
    private double rx,ry;
    private Style style;
    public Ellipse( double rx, double ry, Vec2 center, Style style) {
        this.rx = rx;
        this.ry = ry;
        this.center = center;
        this.style=style;
    }
    @Override
    public String toSvg(String parameter) {
        return String.format(Locale.ENGLISH,"<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\"%s />"
                ,rx,ry,center.x,center.y,parameter);//style.toSvg()

    }
}
