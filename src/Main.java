public class Main {
    public static void main(String[] args) {

        Vec2 point1 = new Vec2(0,120);
        Vec2 point2 = new Vec2(160,130);
        Vec2 point3 = new Vec2(50,50);

        Shape ellipse = new Ellipse(100,80,new Vec2(300,120));
        Shape polygon = new Polygon(new Vec2[]{point1,point2,point3});

        polygon = new DropShadowDecorator(new StrokeShapeDecorator
                (new SolidFillShapeDecorator(polygon, "violet"), "black", 3));
        //the order of decorators is important.

        ellipse = new TransformationDecorator.Builder()
                .setShape(ellipse)
                .setTranslate(point3)
                .setRotate(point3,-10 )
                .setScale(new Vec2(1,0.5))
                .build();
        //ellipse = new SolidFillShapeDecorator(ellipse,"red");
        ellipse = new DropShadowDecorator(ellipse);
        ellipse = new GradientFillShapeDecorator.Builder()
                .setStopOffsetColor(0.0,"yellow")
                .setStopOffsetColor(1.0,"red")
                .setShape(ellipse)
                .build();
        SvgScene.getInstance().addShape(polygon);
        SvgScene.getInstance().addShape(ellipse);
        SvgScene.getInstance().saveHtml("./test.html");
    }
}