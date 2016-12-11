/*
 * 4x4 Image Segmentation Password
 * CPSC 525 - Principles of computer security
 *
 * @Authors:
 * Abigail Oliver
 * Satara Cressy
 * Hannah Mudge 
 *
 */

 To Setup:
  
  -> Go to createUsers() in LoginWindow.java (line 90)
  -> Change the first & second argument of Client() to a unique
     username and a filepath for the password image respectively


 To Run:
 
  -> Play LoginAs.java Window
  -> Can keep entering valid Usernames, so multiple challenge
  	 password screens can be open at the same time	
  		--> Usernames are not case sensitive 
  -> Progress Checker windows for different users can also be opened
  	 concurrently	 
  -> All windows close when a password has been submitted (successful or not)
  
  
  Known Limitations:
  
  -> 4x4 password space is hardcoded even though images can be split into
  	 more chunks
  -> Optimal image size is 784x415 pixels
  		--> Can do smaller images but larger images will
  			not be displayed properly

  	 

 