/**
 * Project: Exam
 * Package: PACKAGE_NAME
 */

/**
 * Triangle Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class Triangle extends Shape {
    private int side1;
    private int side2;
    private int side3;

    Triangle(int id, int side1, int side2, int side3, String color)
    {
        super("Triangle", id, color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }
}
