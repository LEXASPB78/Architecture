package HW_4.Constructor;

public class Constructor {

  public static HW_4.Models.Square createSquare(double side) throws Exception {
      if (side <= 0) {
          throw new Exception("Не получилось создать квадрат. Длина стороны не может быть отрицательной");
      }
      return new HW_4.Models.Square(side,side);
  }

  public static HW_4.Models.Rectangle createRectangle(double width, double height) throws Exception {
      if (width <= 0 || height <= 0) {
          throw new Exception("Не получилось создать прямогульник. Один из размеров был отрицательны.");
      }
      return new HW_4.Models.Rectangle(width, height);
  }

  public static HW_4.Models.Circle createCircle(double radius) throws Exception {
      if (radius <= 0) {
          throw new Exception("Не получилось создать круг. Радиус должен быть положительным.");
      }
      return new HW_4.Models.Circle(radius);
  }

  public static HW_4.Models.Triangle createTriangle(double a, double b, double c)
          throws Exception {
      if (a <= 0 || b <= 0 || c <= 0) {
          throw new Exception("Не получилось создать треугольник, одна из сторон отрицательная");
      }

      if (a + b < c
              || b + c < a
              || a + c < b) {
          throw new Exception("Не получилось создать треугольник, одна из сторон больше суммы двух других");
      }
      return new HW_4.Models.Triangle(a, b, c);
  }
}