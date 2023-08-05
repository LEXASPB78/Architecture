package HW_4.Constructor;

import java.util.ArrayList;

public class Shapes {
    ArrayList<HW_4.Models.Shape> content;

    public Shapes() {
        this.content = new ArrayList<>();
    }

    public void add(HW_4.Models.Shape shape) {
        content.add(shape);
    }

    public String calcAllPerimetrs() {
        StringBuilder sb = new StringBuilder();
        for (HW_4.Models.Shape shape : content) {
            sb.append(String.format("Фигура: %s Периметр: %f \n", shape.description(), shape.calcPerimetr()));
        }
        return sb.toString();
    }

    public String calcAllAreas() {
        StringBuilder sb = new StringBuilder();
        for (HW_4.Models.Shape shape : content) {
            sb.append(String.format("Фигура: %s Площадь: %f \n", shape.description(), shape.calcArea()));
        }
        return sb.toString();
    }
}