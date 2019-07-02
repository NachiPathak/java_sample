package boxings;

public class Book {
	private String title;
	private String author;
	private int publicationYear;
	private double averageRating;
	private int ratingsCount;
	private String imageUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	@Override
	public String toString() {
		return "Book Details: [\nTitle = " + title + "\nAuthor = " + author
				+ "\nPublication Year = " + publicationYear + "\nAverage Rating = "
				+ averageRating + "\nRatings Count = " + ratingsCount
				+ "\nImage Url = " + imageUrl + "\n]";
	}

}