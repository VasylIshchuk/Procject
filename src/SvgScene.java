import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SvgScene {
    private Polygon[] polygons =new Polygon[0];
    public void addPolygon(Polygon polygon){
        this.polygons=Arrays.copyOf(polygons,polygons.length+1);
        this.polygons[polygons.length-1]=polygon;
    }
    public void saveHtml(String path){
        String image ="<svg height=\"220\" width=\"500\">";
        for (Polygon polygon : polygons){
            image +=polygon.toSvg();
        }
        image+="</svg>";
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(image);
            fileWriter.close();
        } catch (IOException e) {}
    }
}
