import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SvgScene {
    private Shape[] shapes = new Shape[0];
    private static SvgScene instance = null;
    private String []defs = new String[0];
    public void addShape(Shape shape){
        this.shapes=Arrays.copyOf(shapes,shapes.length+1);
        this.shapes[shapes.length-1]=shape;
    }
    public static SvgScene getInstance() {
        if(instance==null)  instance = new SvgScene();
        return instance;
    }
    public void addDefs(String def){
        this.defs=Arrays.copyOf(defs,defs.length+1);
        this.defs[defs.length-1]=def;
    }
    public void saveHtml(String path){
        StringBuilder image=new StringBuilder();
        image.append("<svg height=\"220\" width=\"500\"> \n");

            image.append("\t<defs> \n");
            for (String def : defs) {
                image.append(def).append("\n");
            }
            image.append("\t</defs> \n");

        for (Shape shape : shapes){
            image.append(shape.toSvg("")).append("\n");
        }
        image.append("</svg> \n");

        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(String.valueOf(image));
            fileWriter.close();
        } catch (IOException e) {}
    }
}
