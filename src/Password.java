import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;

/* Password: A single password is an array of 16 ordered images */
public class Password {
	
	private ImgSeg[] images = new ImgSeg[16]; 

	/* Constructor for Password takes in a filePath, gets the image, 
	 * splits it into chunks and saves it as the users password */
	public Password(String imagePath) {
		
		SplitImage img = new SplitImage(imagePath);
		BufferedImage[] chunks = img.getImageChunks();
		
		images = new ImgSeg[16]; 
		for(int i = 0; i < chunks.length; i++)
		{
			images[i] = new ImgSeg(chunks[i], i);
		}
	}
	
	/* Randomize the image chunks for a challenge password */
	public ImgSeg[] getChallengePassword()
	{
		ImgSeg[] challengePassword = cloneImages();
		Collections.shuffle(Arrays.asList(challengePassword));	
		return challengePassword;
	}
	
	/* Clone password because references are a son of a bitch */
	private ImgSeg[] cloneImages()
	{
		ImgSeg[] clone = new ImgSeg[16];
		for(int i = 0; i < images.length; i++)
		{
			clone[i] = new ImgSeg(images[i].getImgSegment(), images[i].getImgName());
		}
		
		return clone;
	}
	
	/* Check if password is successful */
	public boolean checkPassword(ImgSeg[] currPass)
	{	
		
		for(int i = 0; i < images.length; i++)
		{
			if(images[i].getImgName() != currPass[i].getImgName())
			{
				return false;
			}
		}

		return true;
	}

	/*======= Getters and Setters ========*/
	public ImgSeg[] getImages() {
		return images;
	}

	public void setImages(ImgSeg[] images) {
		this.images = images;
	}
	
}
