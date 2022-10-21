package liga.medical.medicalmonitoring.core.solid;

public class AntiL {

    //antiL это прямоугольник
    private double width = 0d;
    private double height = 0d;

    public AntiL() {
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }
}

class Square extends AntiL {
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        super.setWidth(height);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

}
