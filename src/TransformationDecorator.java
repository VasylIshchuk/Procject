import java.util.Locale;

//  Adds to the shape transformations.
//  (Concrete Decorator) Implementation of a concrete decorator that adds additional functionality to our shape (concrete component(Polygon..)).
public class TransformationDecorator extends ShapeDecorator {
    private final boolean translate;
    private final boolean rotate;
    private final boolean scale;
    private final double rotateAngle;
    private final Vec2 translateVector;
    private final Vec2 rotateCenter;
    private final Vec2 scaleVector;

    //      This constructor is called when the "build" method is invoked from the Builder. It receives the shape
    //      to which the functionality will be added and takes the settings from the Builder object,
    //      assigning them to the fields so that they can later be used in "toSvg".
    public TransformationDecorator(Shape decoratedShape, Builder builder) {
        super(decoratedShape);
        this.translate = builder.translate;
        this.translateVector = builder.translateVector;

        this.rotate = builder.rotate;
        this.rotateAngle = builder.rotateAngle;
        this.rotateCenter = builder.rotateCenter;

        this.scale = builder.scale;
        this.scaleVector = builder.scaleVector;
    }
    //    This is exactly what gets added to our shape in SVG, and it is passed as "parameter".
    @Override
    public String toSvg(String parameter) {
        StringBuilder stringBuilder = new StringBuilder();
        if (translate) stringBuilder.append(String.format(Locale.ENGLISH, "translate(%f %f) ",
                translateVector.x, translateVector.y));
        if (rotate) stringBuilder.append(String.format(Locale.ENGLISH, "rotate(%f %f %f) ",
                rotateAngle, rotateCenter.x, rotateCenter.y));
        if (scale) stringBuilder.append(String.format(Locale.ENGLISH, "scale(%f %f) ",
                scaleVector.x, scaleVector.y));
        return super.toSvg(String.format(Locale.ENGLISH,
                " transform=\"%s\"%s", stringBuilder, parameter));
    }

    //   "Builder" - a structural design pattern.
    //   To add multiple functionalities to a shape at once, we use a Builder.
    //   When initializing this decorator in main, we first initialize this Builder subclass, which specifies
    //   the functionalities and their values that we want to add to the shape through the invocation of corresponding methods.
    public static class Builder {
        private boolean translate = false, rotate = false, scale = false;
        private double rotateAngle;
        private Vec2 translateVector, rotateCenter, scaleVector;
        private Shape shape;

        //  To specify which shape the new functionality will be added to.
        public Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
            //  Returns a reference to the Builder object to allow method calls one after another.
        }

        public Builder setTranslate(Vec2 translateVector) {
            this.translateVector = translateVector;
            this.translate = true;
            return this;
        }

        public Builder setRotate(Vec2 rotateCenter, double rotateAngle) {
            this.rotateCenter = rotateCenter;
            this.rotateAngle = rotateAngle;
            this.rotate = true;
            return this;
        }

        public Builder setScale(Vec2 scaleVector) {
            this.scaleVector = scaleVector;
            this.scale = true;
            return this;
        }

        //      The build() method, which creates an instance of the TransformationDecorator class
        //      and passes the Builder object with configured parameters. (setScale, etc.).
        public TransformationDecorator build() {
            return new TransformationDecorator(shape, this);
        }
    }
}
