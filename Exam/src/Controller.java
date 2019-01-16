/**
 * Project: Exam
 * Package: PACKAGE_NAME
 */

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.xpath.XPathExpressionException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class Controller {
    private WindowView windowView;
    private XMLHandler handler;

    public Controller()
    {
        init();
        actionListeners();
    }

    private void init()
    {
        windowView = new WindowView();
        handler = new XMLHandler();

        try {
            handler.loadFile(new File("./shapes.xml"));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        try {
            handler.generateXPath("/shapes/child::node()");
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        ArrayList<Shape> shapes = handler.getShapes();

        populateShapesList(shapes);
    }

    public void populateShapesList(ArrayList<Shape> shapes)
    {
        windowView.getContentView().populateShapesList(shapes);
    }

    public void populatePropertiesList(Shape shape)
    {
        windowView.getContentView().populateProperties(shape);
    }

    public void actionListeners()
    {
        windowView.getContentView().getShapeList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list =(JList) e.getSource();

                if(e.getClickCount() == 1)
                {
                    Shape shape = (Shape) list.getSelectedValue();
                    populatePropertiesList(shape);
                    ImageLabel imageLabel = (ImageLabel) windowView.getContentView().getImageLabel();
                    imageLabel.setImage(shape.getType());
                }
            }
        });
    }
}
