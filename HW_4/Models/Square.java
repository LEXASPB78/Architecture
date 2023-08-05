package HW_4.Models;

public class Square extends Rectangle {
    private double side;

    public Square(double width, double height) {
        super(width, height);
        this.side = width;

    }

    @Override
    public double calcPerimetr() {
        return side * 4;
    }

    @Override
    public double calcArea() {
        return side * side;
    }

    public String description() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Квадрат co стороной ").append(side).append(".").toString();
    }
}