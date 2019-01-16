/**
 * Project: Exam
 * Package: PACKAGE_NAME
 */

/**
 * Circle Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class Circle extends Shape{
    private int radius;

    Circle(int id, int radius, String color)
    {
        super("Circle", id, color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}
