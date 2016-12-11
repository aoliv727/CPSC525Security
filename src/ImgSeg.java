import java.awt.image.BufferedImage;


/* ImgSeg: Holds a named image segment */
public class ImgSeg {

	private BufferedImage imgSegment;
	private int imgName;
	
	/* ImgSeg Constructor */
	public ImgSeg(BufferedImage imgSeg, int name) {
		this.imgSegment = imgSeg;
		this.imgName = name;
	}

	
	/*======= Getters and Setters ========*/
	public int getImgName() {
		return imgName;
	}

	public void setImgName(int imgName) {
		this.imgName = imgName;
	}

	public BufferedImage getImgSegment() {
		return imgSegment;
	}

	public void setImgSegment(BufferedImage imgSegment) {
		this.imgSegment = imgSegment;
	}

}
