package HW_4.Models;

public class Triangle implements Shape{
    private double a;
    private double b;
    private double c;
    
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
  
    @Override
    public double calcPerimetr() {
        return a + b + c;
    }
  
    @Override
    public double calcArea() {
        double halfPerimetr = calcPerimetr() / 2;
        return Math.sqrt(halfPerimetr*(halfPerimetr-a)
                                     *(halfPerimetr-b)
                                     *(halfPerimetr-c));
    }
  
    public String description(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Треугольник со сторонами ").append(a).append(", ").append(b).append(", ").append(c).append(".").toString();
    }
  }