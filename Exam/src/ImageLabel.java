/**
 * Project: Exam
 * Package: PACKAGE_NAME
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * ImageLabel Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class ImageLabel extends JLabel {
    private int imageHeight, imageWidth;
    private BufferedImage image;

    ImageLabel()
    {
        super();
    }

    public void setImage(String shape)
    {
        // grab the image
        try {
            this.image = ImageIO.read(new File(shape.toLowerCase() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // scale the image
        Image scaledImage = image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);

        // create an icon out of the image
        ImageIcon icon = new ImageIcon(scaledImage);

        this.setIcon(icon);
    }
}
