import java.util.Locale;

public class DropShadowDecorator extends  ShapeDecorator{
    public DropShadowDecorator(Shape decoratedShape) {
        super(decoratedShape);
        SvgScene.getInstance().addDefs(String.format(Locale.ENGLISH,"\t<filter id=\"f%d\" x=\"-100%%\" y=\"-100%%\" width=\"300%%\" height=\"300%%\">\n" +
                "\t\t<feOffset result=\"offOut\" in=\"SourceAlpha\" dx=\"5\" dy=\"5\" />\n" +
                "\t\t<feGaussianBlur result=\"blurOut\" in=\"offOut\" stdDeviation=\"5\" />\n" +
                "\t\t<feBlend in=\"SourceGraphic\" in2=\"blurOut\" mode=\"normal\" />\n" +
                "\t</filter>",hashCode()));
    }
    @Override
    public String toSvg(String parameter) {
        return super.toSvg(String.format(Locale.ENGLISH,"filter=\"url(#f%d)\" %s",hashCode(),parameter));
    }
}
