import java.util.Locale;

public class Ellipse implements Shape{
    private Vec2 center;
    private double rx,ry;
    private Style style;
    public Ellipse(Style style, Vec2 center, double rx, double ry) {
        this.center = center;
        this.rx = rx;
        this.ry = ry;
        this.style=style;
    }
    @Override
    public String toSvg() {
        return String.format(Locale.ENGLISH,"<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\"%s />"
                ,rx,ry,center.x,center.y,style.toSvg());

    }
}
