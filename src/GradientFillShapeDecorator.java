import java.util.Arrays;
import java.util.Locale;

public class GradientFillShapeDecorator extends ShapeDecorator {

    //      This constructor is called when the "build" method is invoked from the Builder. It receives the shape
    //      to which the functionality will be added and takes the settings from the Builder object.
    public GradientFillShapeDecorator(Shape decoratedShape, Builder builder) {
        super(decoratedShape);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(Locale.ENGLISH, "\t\t<linearGradient id=\"g%d\">\n"
                , hashCode()));
        for (Builder attributes : builder.builders) {
            stringBuilder.append(String.format(Locale.ENGLISH, "\t\t\t<stop offset=\"%f\" " +
                    "style=\"stop-color:%s\"/>\n", attributes.stopOffset, attributes.stopColor));
        }
        stringBuilder.append("\t\t</linearGradient>");
        SvgScene.getInstance().addDefs(String.valueOf(stringBuilder));
    }
    //    We don't insert this(above) directly into the shape's parameters; instead, we create a reference to it because
    //    we add it to the toSvg parameter, "fill", which points to this content. The content itself will be placed
    //    in the <defs> block, so we add it to the defs table where it will be stored.
    @Override
    public String toSvg(String parameter) {
        return super.toSvg(String.format(Locale.ENGLISH, "fill=\"url(#g%d)\" %s", hashCode(), parameter));
    }

    public static class Builder {
        private Builder[] builders = new Builder[0];
        private double stopOffset;
        private String stopColor;
        private Shape shape;

        //      This constructor is needed to initialize an object that has two fields (stopOffset, stopColor).
        public Builder(double stopOffset, String stopColor) {
            this.stopOffset = stopOffset;
            this.stopColor = stopColor;
        }

        //      This empty constructor is needed to call the no-argument constructor in main.
        public Builder() {
        }

        public Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }

        //  This method is used to set the values for stopOffset and stopColor.
        //      The stop-color attribute in <stop> defines the color of the gradient stop.
        //      The offset attribute in <stop> defines where the gradient stop is placed.
        //  To allow these values to be set multiple times, we initialize them as fields of the Builder object
        //  and add them to the "builders" table
        public Builder setStopOffsetColor(double stopOffset, String stopColor) {
            this.builders = Arrays.copyOf(builders, builders.length + 1);
            this.builders[builders.length - 1] = new Builder(stopOffset, stopColor);
            return this;
        }

        //      The build() method, which creates an instance of the GradientFillShapeDecorator class
        //      and passes the Builder object with configured parameters. (setStopOffsetColor, etc.).
        public GradientFillShapeDecorator build() {
            return new GradientFillShapeDecorator(shape, this);
        }
    }
}
