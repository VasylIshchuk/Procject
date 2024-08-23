import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

//  "Singleton" - a structural design pattern.
//  I use this pattern to ensure that only one object (one SVG Scene) is created.
//  It guarantees that any code requiring access to this class always receives the same object (the single SVG Scene).
public class SvgScene {
    private static SvgScene instance = null;
    private Shape[] shapes = new Shape[0];
    private String[] defs = new String[0];

    //  A private constructor to prevent the creation of an object of the class outside the class itself.
    private SvgScene() {
    }

    //  A method that ensures only one object is created.
    public static SvgScene getInstance() {
        if (instance == null) instance = new SvgScene();
        return instance;
    }

    //  A method that stores all the shapes that will be on the SVG scene.
    public void addShape(Shape shape) {
        this.shapes = Arrays.copyOf(shapes, shapes.length + 1);
        this.shapes[shapes.length - 1] = shape;
    }

    //   A method that stores all SVG that will be on the <defs> block.
    public void addDefs(String def) {
        this.defs = Arrays.copyOf(defs, defs.length + 1);
        this.defs[defs.length - 1] = def;
    }

    //  Creates the SVG file by adding all the SVG elements from the toSvg methods of all the shapes stored in the "shapes" table
    public void saveHtml(String path) {
        StringBuilder image = new StringBuilder();
        image.append("<svg height=\"220\" width=\"500\" xmlns=\"http://www.w3.org/2000/svg\"> \n");

        if (defs.length > 0) {
            image.append("\t<defs> \n");
            for (String def : defs) {
                image.append(def).append("\n");
            }
            image.append("\t</defs> \n");
        }

        for (Shape shape : shapes) {
            image.append(shape.toSvg("")).append("\n");
        }
        image.append("</svg> \n");

        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(String.valueOf(image));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
