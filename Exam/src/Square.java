/**
 * Project: Exam
 * Package: PACKAGE_NAME
 */

/**
 * Square Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class Square extends Shape {
    private int side;

    Square(int id, int side, String color)
    {
        super("Square", id, color);
        this.side = side;
    }

    public int getSide() {
        return side;
    }
}
