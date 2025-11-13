package beans;

import java.io.Serializable;
import java.util.Date;

public class Point implements Serializable {
    Integer x;
    private Double y, r;
    private String result;
    private Date stime;
    private Long rtime;
    public Point(Integer x, Double y, Double r, String result){
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
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
    public String getResult() {
        return result;
    }

    public Long getRtime() {
        return rtime;
    }

    public void setRtime(Long rtime) {
        this.rtime = rtime;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }
}
