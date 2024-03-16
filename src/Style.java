import java.util.Locale;

public class Style {
    public final String fillColor,strokeColor;
    public final Double strokeWidth;
    public Style(String fillColor, String strokeColor, Double strokeWidth) {
        if(fillColor==null) this.fillColor = "transparent";
        else this.fillColor = fillColor;
        if(strokeColor==null) this.strokeColor = "black";
        else  this.strokeColor = strokeColor;
        if(strokeWidth==null) this.strokeWidth = 1.0;
        else this.strokeWidth = strokeWidth;
    }
    public String toSvg(){
        return String.format(Locale.ENGLISH, " style=\"fill:%s;stroke:%s;stroke-width:%f\" ",
                this.fillColor,this.strokeColor,this.strokeWidth);
    }
}
