package HW_4.Models;

public class Circle implements Shape {
    private double radius;
  
    public Circle(double radius) {
        this.radius = radius;
    }
  
    @Override
    public double calcPerimetr() {
        return 2 * Math.PI * radius;
    }
  
    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }
  
    public String description(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Круг радиусом ").append(radius).append(".").toString();
    }
  }