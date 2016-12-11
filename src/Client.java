
/* Client: A single client is a username and password pairing */
public class Client {

	private String username;
	private Password password;
	
	/* Client Constructor */
	public Client(String username, String passwordPath)
	{
		this.username = username;
		this.password = new Password(passwordPath);
	}
	
	/* Check for successful login */
	public boolean checkPassword(ImgSeg[] currPass)
	{
		return password.checkPassword(currPass);
	}
	
	/* Return a challenge password based on this Clients password */
	public ImgSeg[] getChallengePassword()
	{
		return password.getChallengePassword();
	}

	/*======== Getters and setters =========*/
	public String getUsername()
	{
		return username;
	}
	
}
