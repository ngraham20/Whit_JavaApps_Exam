/**
 * Project: Exam
 * Package: PACKAGE_NAME
 */

import javax.swing.*;
import java.awt.*;

/**
 * WindowView Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class WindowView extends JFrame {

    private ContentView contentView = new ContentView();

    public WindowView()
    {
        super();

        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(contentView);

    }

    public ContentView getContentView() {
        return contentView;
    }
}
