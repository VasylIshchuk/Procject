import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SvgScene {
    private Shape[] shapes =new Shape[0];
    public void addShape(Shape shape){
        this.shapes=Arrays.copyOf(shapes,shapes.length+1);
        this.shapes[shapes.length-1]=shape;
    }
    public void saveHtml(String path){
        String image ="<svg height=\"220\" width=\"500\">";
        for (Shape shape : shapes){
            image +=shape.toSvg("");
        }
        image+="</svg>";
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(image);
            fileWriter.close();
        } catch (IOException e) {}
    }
}
