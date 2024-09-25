package Data_access;

public class Movie {
	
	private int movieid;
	private String moviename;
	private String movieimgPath;
	private String movieshortdes;
	private String movielongdes;
	private String moviepath;
	
	public Movie(int movieid, String moviename, String movieimgPath, String movieshortdes, String movielongdes,String moviepath) {
		
		this.movieid = movieid;
		this.moviename = moviename;
		this.movieimgPath = movieimgPath;
		this.movieshortdes = movieshortdes;
		this.movielongdes = movielongdes;
		this.moviepath = moviepath;
	}

	public int getMovieid() {
		return movieid;
	}

	public String getMoviename() {
		return moviename;
	}

	public String getMovieimgPath() {
		return movieimgPath;
	}

	public String getMovieshortdes() {
		return movieshortdes;
	}

	public String getMovielongdes() {
		return movielongdes;
	}

	public String getMoviepath() {
		return moviepath;
	}

	
	
	
	
	
	

}
