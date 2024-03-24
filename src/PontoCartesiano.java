
public class PontoCartesiano {
    double x1;
    double y1;

    double x2;

    double y2;

    double d;


    public PontoCartesiano(double x2, double x1, double y2, double y1) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }



    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }


    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getD() {
        return d;

    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }


    public double CalcDistanciaEuclidiana(){
    d = ((getX2() - getX1()) * (getX2() - getX1())) + ((getY2() - getY1()) * (getY2() - getY1()));
    d = java.lang.Math.sqrt(d);
    return d;
    }



}
