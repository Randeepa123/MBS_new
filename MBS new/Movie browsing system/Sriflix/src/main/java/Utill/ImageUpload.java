package Utill;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.servlet.http.Part;


public class ImageUpload {
	
	public static void Filehandle(Part file,String filename,Part image,String imagename) {
	
	String Imagepath="D:/github/MBS new/Movie browsing system/Sriflix/src/main/webapp/UploadedImages";
	String Moviepath="D:/github/MBS new/Movie browsing system/Sriflix/src/main/webapp/UploadedMovies";
	
	File uploadfolder=new File(Imagepath);
	
	if(!uploadfolder.exists()) {
		
		uploadfolder.mkdir();
		}
	
	
	File uploadMovie=new File(Moviepath);
	
	if(!uploadMovie.exists()) {
		
		uploadMovie.mkdir();
		}
	
	String uploadImage="D:/github/MBS new/Movie browsing system/Sriflix/src/main/webapp/UploadedImages/"+imagename;
    System.out.println(uploadImage);
    
    String uploadmovie="D:/github/MBS new/Movie browsing system/Sriflix/src/main/webapp/UploadedMovies/"+filename;
    System.out.println(uploadmovie);
    
   try { 
    FileOutputStream fos=new FileOutputStream(uploadImage);
	InputStream is= image.getInputStream();
	
	byte[] data =new byte[is.available()];
	is.read(data);
	fos.write(data);
	fos.close();
	is.close();	
	
   }catch (Exception e) {
	   e.printStackTrace();
   		}
   
   try {
	   	
	    FileOutputStream fos=new FileOutputStream(uploadmovie);
	    InputStream is= file.getInputStream();
		
		byte[] data =new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		is.close();	
	
			
		
		
	   }catch (Exception e) {
		   e.printStackTrace();
	   		}
   

	}
}
