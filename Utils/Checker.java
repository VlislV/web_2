package Utils;

import java.util.Arrays;

public class Checker {
    Integer x;
    Double y,r;
    Integer[] validX = {-3, -2, -1, 0, 1, 2, 3, 4, 5};

    public Checker(String x, String y, String r) throws Exception{
        this.x = Integer.parseInt(x);
        this.y = Double.parseDouble(y);
        this.r = Double.parseDouble(r);
    }
    public String validate(){
        if(!Arrays.asList(validX).contains(x)){
            return "Invalid X value";
        }
        if(y <= -5 || y >= 3){
            return "Y must be between -5 and 3";
        }
        if(r <= 2 || r >= 5){
            return "R must be between 2 and 5";
        }
        return "OK";
    }

    public String check(){
        if (y >= 0 && x <= 0 && 2 * y <= x + r)
            return "HIT in triangle";
        if (y <= 0 && x <= 0 && x > -r/2 && y > -r)
            return "HIT in rectangle";
        if (x >= 0 && y <= 0 && x * x + y * y <= (double) r / 2 * r / 2)
            return "HIT in circle";
        return "MISS";
    }

    public Integer getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getR() {
        return r;
    }
}
