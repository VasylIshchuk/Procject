import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator {
    private  boolean translate,rotate,scale;
    private double rotateAngle;
    private Vec2 translateVector,rotateCenter,scaleVector;
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
    @Override
    public String toSvg(String parameter) {
        StringBuilder stringBuilder=new StringBuilder();
        if(translate) stringBuilder.append(String.format(Locale.ENGLISH, "translate(%f %f) ",
                translateVector.x, translateVector.y));
        if (rotate) stringBuilder.append(String.format(Locale.ENGLISH,"rotate(%f %f %f) ",
                rotateAngle, rotateCenter.x, rotateCenter.y));
        if(scale) stringBuilder.append(String.format(Locale.ENGLISH,"scale(%f %f) ",
                scaleVector.x, scaleVector.y));
        return  super.toSvg(String.format(Locale.ENGLISH,
                " transform=\"%s\"%s",stringBuilder,parameter));
    }
    public static  class Builder  {
        private  boolean translate=false,rotate=false,scale=false;
        private double rotateAngle;
        private Vec2 translateVector,rotateCenter,scaleVector;
        private Shape shape;
        public Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }
        public Builder setTranslate(Vec2 translateVector) {
            this.translateVector=translateVector;
            this.translate = true;
            return this;
        }
        public Builder setRotate(Vec2 rotateCenter, double rotateAngle) {
            this.rotateCenter = rotateCenter;
            this.rotateAngle=rotateAngle;
            this.rotate=true;
            return this;
        }
        public Builder setScale(Vec2 scaleVector) {
            this.scaleVector = scaleVector;
            this.scale=true;
            return this;
        }
        public TransformationDecorator build(){
            return new TransformationDecorator(shape,this);
        }

    }
}
