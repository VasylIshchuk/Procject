public class Main {
    public static void main(String[] args) {
        // Laboratorium 1
        //1
        Point point1=new Point(2,2);
        Point point2=new Point(4,2);
        Segment segment =new Segment(point2,point1);
        System.out.println(segment.lengthSection()+ "\n");
        //2
        System.out.println(segment.toSvg()+ "\n");
        //3
        Point point = new Point(3,4);
        Segment []arr=Segment.perpendicular(segment,point,3);
        //4
        Point[] arr_points=new Point[3];
        for(int i = 0; i < arr_points.length; ++i){
            arr_points[i]=new Point(1,3);
        }
        Polygon polygon =new Polygon(arr_points);
        polygon.print();
    }
}