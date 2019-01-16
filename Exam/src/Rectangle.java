/**
 * Project: Exam
 * Package: PACKAGE_NAME
 */

/**
 * Rectangle Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class Rectangle extends Shape {
    private int width;
    private int length;

    Rectangle(int id, int width, int length, String color)
    {
        super("Rectangle", id, color);
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    @Override
    public double getPerimeter() {
        return 2*width + 2*length;
    }

    @Override
    public double getArea() {
        return width * length;
    }
}
