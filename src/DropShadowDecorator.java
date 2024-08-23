import java.util.Locale;

//  Adds a shadow to the shape.
//  (Concrete Decorator) Implementation of a concrete decorator that adds additional functionality to our shape (concrete component(Polygon..)).
public class DropShadowDecorator extends ShapeDecorator {
    //    Sends the shapes along with preset parameters to add a shadow.
    public DropShadowDecorator(Shape decoratedShape) {
        super(decoratedShape);
        SvgScene.getInstance().addDefs(String.format(Locale.ENGLISH,
                "\t\t<filter id=\"f%d\" x=\"-100%%\" y=\"-100%%\" width=\"300%%\" height=\"300%%\">\n" +
                        "\t\t\t<feOffset result=\"offOut\" in=\"SourceAlpha\" dx=\"5\" dy=\"5\"/>\n" +
                        "\t\t\t<feGaussianBlur result=\"blurOut\" in=\"offOut\" stdDeviation=\"5\"/>\n" +
                        "\t\t\t<feBlend in=\"SourceGraphic\" in2=\"blurOut\" mode=\"normal\"/>\n" +
                        "\t\t</filter>", hashCode()));
    }

    //    We don't insert this(above) directly into the shape's parameters; instead, we create a reference to it because
    //    we add it to the toSvg parameter, "filter", which points to this content. The content itself will be placed
    //    in the <defs> block, so we add it to the defs table where it will be stored.
    @Override
    public String toSvg(String parameter) {
        return super.toSvg(String.format(Locale.ENGLISH, "filter=\"url(#f%d)\" %s", hashCode(), parameter));
    }
}
