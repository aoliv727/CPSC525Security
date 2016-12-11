import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

/* SplitImage: Takes image path and returns Array of image chunks */
public class SplitImage {
	private String filePath;

	/* SplitImage Constructor */
	public SplitImage(String filePath) {
		this.filePath = filePath;
	}

	/* Load Image and store in chunks */
	public BufferedImage[] getImageChunks()
	{
		File file = new File(filePath); 
        FileInputStream fileIn;
        BufferedImage image = null;
        
		try {
			fileIn = new FileInputStream(file);
			image = ImageIO.read(fileIn); //reading the image file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        int rows = 4; //The values for rows and cols variables
        int cols = 4;
        int chunks = rows * cols;

        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
            	
                //Initialize the image array with image chunks (in order)
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                // draws the image chunk 
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }
        
        return imgs;
	}
	
}
