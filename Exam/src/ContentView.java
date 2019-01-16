/**
 * Project: Exam
 * Package: PACKAGE_NAME
 */

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * ContentView Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class ContentView extends JPanel {

    private JPanel sideBar = new JPanel();
    private JPanel body = new JPanel();
    private JLabel imageLabel = new ImageLabel();
    private JList<String> properties = new JList<>();
    private JList<Shape> shapeList = new JList<>();

    private JScrollPane scrollPane;


    public ContentView()
    {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {

        this.setLayout(new BorderLayout());
        sideBar.setLayout(new BorderLayout());
        body.setLayout(new BorderLayout());

        body.add(imageLabel, BorderLayout.WEST);
        body.add(properties, BorderLayout.CENTER);

        this.add(sideBar, BorderLayout.WEST);
        this.add(body, BorderLayout.CENTER);

        scrollPane = new JScrollPane(shapeList,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        sideBar.add(scrollPane);
        setSizes();
        setColors();

    }

    void setSizes()
    {
        sideBar.setPreferredSize(new Dimension(200, -1));
        imageLabel.setPreferredSize(new Dimension(400, -1));
    }

    void setColors()
    {
        shapeList.setBackground(Color.MAGENTA);
        imageLabel.setBackground(Color.RED);
        body.setBackground(Color.ORANGE);
        properties.setBackground(Color.GREEN);
    }

    public void populateShapesList(ArrayList<Shape> shapes)
    {
        // this will populate the jlist with shapes
        DefaultListModel<Shape> lm = new DefaultListModel<>();
        for (Shape shape : shapes) {
            lm.addElement(shape);
        }
        shapeList.setModel(lm);
    }

    public void populateProperties(Shape shape)
    {
        DefaultListModel<String> lm = new DefaultListModel<>();
        lm.addElement("Type: " + shape.getType());
        lm.addElement("ID: " + shape.getId());
        lm.addElement("Color: " + shape.getColor());

        switch (shape.getType())
        {
            case "Circle":
                lm.addElement("Radius: " + ((Circle)shape).getRadius());
                break;
            case "Triangle":
                lm.addElement("Side 1: " + ((Triangle)shape).getSide1());
                lm.addElement("Side 2: " + ((Triangle)shape).getSide2());
                lm.addElement("Side 3: " + ((Triangle)shape).getSide3());
                break;
            case "Square":
                lm.addElement("Side: " + ((Square)shape).getSide());
                break;
            case "Rectangle":
                lm.addElement("Length: " + ((Rectangle)shape).getLength());
                lm.addElement("Width: " + ((Rectangle)shape).getWidth());
                break;
        }
        properties.setModel(lm);
    }

    public JList<String> getProperties() {
        return properties;
    }

    public JList<Shape> getShapeList() {
        return shapeList;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }
}
