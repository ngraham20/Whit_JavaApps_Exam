/**
 * Project: Exam
 * Package: PACKAGE_NAME
 */

/**
 * Shape Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public abstract class Shape {

    private String type;
    private int id;
    private String color;

    Shape()
    {
    }

    Shape(String type, int id, String color)
    {
        this.type = type;
        this.id = id;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return type;
    }
}
