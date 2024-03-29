import java.util.Arrays;
import java.util.Locale;

public class GradientFillShapeDecorator extends  ShapeDecorator{
    private Builder [] builders;
    public GradientFillShapeDecorator(Shape decoratedShape,Builder builder) {
        super(decoratedShape);
        this.builders = builder.builders;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(Locale.ENGLISH,"\t<linearGradient id=\"g%d\" >\n"
                ,hashCode()));
        for(Builder builder0 :builders){
            stringBuilder.append(String.format(Locale.ENGLISH,"\t\t<stop offset=\"%f\" " +
                            "style=\"stop-color:%s\" />\n", builder0.stopOffset, builder0.stopColor));
        }
        stringBuilder.append("\t</linearGradient>");
        SvgScene.getInstance().addDefs(String.valueOf(stringBuilder));

    }
    public static class Builder{
        private Builder [] builders=new Builder[0];
        private double stopOffset;
        private  String stopColor;
        private  Shape shape;
        public Builder(double stopOffset, String stopColor) {
            this.stopOffset = stopOffset;
            this.stopColor = stopColor;
        }
        public Builder() {
        }
        public Builder setShape(Shape shape) {
            this.shape = shape;
            return this;
        }
        public Builder setStopOffsetColor(double stopOffset, String stopColor) {
            this.builders= Arrays.copyOf(builders,builders.length+1);
            this.builders[builders.length-1]=new Builder(stopOffset,stopColor);
            return this;
        }
        public GradientFillShapeDecorator build() {
            return new GradientFillShapeDecorator(shape,this);
        }
    }
    @Override
    public String toSvg(String parameter) {
        return super.toSvg(String.format(Locale.ENGLISH,"fill=\"url(#g%d)\" %s",hashCode(),parameter));
    }
}
