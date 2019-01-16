/**
 * Project: Exam
 * Package: PACKAGE_NAME
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * XMLHandler Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class XMLHandler {

    private FileInputStream fileIS;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document xmlDocument;
    private XPath xpath;
    private NodeList nodeList;
    private File file;

    public XMLHandler()
    {
        try {
            init();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void init() throws ParserConfigurationException {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        xpath = XPathFactory.newInstance().newXPath();
    }

    void loadFile(File file) throws IOException, SAXException {
        this.file = file;
        if (file != null) {
            fileIS = new FileInputStream(this.file);
            xmlDocument = builder.parse(fileIS);
        }
    }

    void generateXPath(String expression) throws XPathExpressionException {
        nodeList = (NodeList) xpath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
    }

    ArrayList<Shape> getShapes()
    {
        ArrayList<Shape> shapes = new ArrayList<>();
        if (nodeList != null)
        {
            int length = nodeList.getLength();
            for (int i = 0; i < length; i++)
            {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) nodeList.item(i);
                    int id = Integer.parseInt(element.getAttribute("id"));
                    String color = element.getAttribute("color");
                    switch (element.getNodeName()) {
                        case "circle":
                            int radius = Integer.parseInt(element.getAttribute("radius"));
                            shapes.add(new Circle(id, radius, color));
                            break;
                        case "square":
                            int side = Integer.parseInt(element.getAttribute("side"));
                            shapes.add(new Square(id, side, color));
                            break;
                        case "triangle":
                            int side1 = Integer.parseInt(element.getAttribute("side1"));
                            int side2 = Integer.parseInt(element.getAttribute("side2"));
                            int side3 = Integer.parseInt(element.getAttribute("side3"));
                            shapes.add(new Triangle(id, side1, side2, side3, color));
                            break;
                        case "rectangle":
                            int _width = Integer.parseInt(element.getAttribute("width"));
                            int _length = Integer.parseInt(element.getAttribute("length"));
                            shapes.add(new Rectangle(id, _width, length, color));
                            break;
                    }
                }
            }
        }
        return shapes;
    }
}
