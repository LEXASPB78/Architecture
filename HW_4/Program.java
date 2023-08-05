package HW_4;

import HW_4.Constructor.Constructor;
import HW_4.Constructor.Shapes;

public class Program {
  public static void main(String[] args) {
      Shapes shapesArray = new Shapes();

      try {
          shapesArray.add(Constructor.createCircle(5));    
          shapesArray.add(Constructor.createCircle(-2));    
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }

      try {
          shapesArray.add(Constructor.createRectangle(2,4));
          shapesArray.add(Constructor.createRectangle(-3,5));
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }

      try {
          shapesArray.add(Constructor.createRectangle(5,-2));
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }

      try {
          shapesArray.add(Constructor.createSquare(7));
          shapesArray.add(Constructor.createSquare(-4));
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }

      try {
          shapesArray.add(Constructor.createTriangle(5,3,7));
          shapesArray.add(Constructor.createTriangle(4,3,9));
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }

      System.out.println("--------------------\nПериметры всех фигур");
      System.out.print(shapesArray.calcAllPerimetrs());
      
      System.out.println("--------------------\nПлощади всех фигур");
      System.out.print(shapesArray.calcAllAreas());
  }
}