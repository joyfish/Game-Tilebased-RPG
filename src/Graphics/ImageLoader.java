package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by crashh on 04-10-2014.
 */
public class ImageLoader {

    /**
     * This loads in the image, from the given path, and returns the image.
     * @param path path to file.
     * @return image.
     */
    public BufferedImage load(String path){
        try {
            return ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
