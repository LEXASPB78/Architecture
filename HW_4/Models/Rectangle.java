package HW_4.Models;

public class Rectangle implements Shape {
    private double width;
    private double height;
  
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
  
    @Override
    public double calcPerimetr() {
        return (width+height)*2;
    }
  
    @Override
    public double calcArea() {
        return width*height;
    }
  
    public String description(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Прямоугольник со сторонами ").append(width).append(", ").append(height).append(".").toString();
    }
  }