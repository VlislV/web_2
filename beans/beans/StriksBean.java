package beans;

import java.io.Serializable;
import java.util.LinkedList;

public class StriksBean implements Serializable {
    private final LinkedList<Point> contents;
    public StriksBean(){
        contents = new LinkedList<Point>();
    }
    public void addPoint(Point point){
        contents.add(point);
    }
    public LinkedList<Point> getContents() {
        return contents;
    }
}
