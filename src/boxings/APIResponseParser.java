package boxings;

public class APIResponseParser {

	/**
	 * Parses the input text and returns a Book instance containing the parsed
	 * data.
	 * 
	 * @param response
	 *            text to be parsed
	 * @return Book instance containing parsed data
	 */

	public static Book parse(String response) {
		Book book = new Book();
		String endRule = "<";

		String startRule = "<title";
		String title = parse(response, startRule, endRule);
		book.setTitle(title);

		startRule = "<name";
		String author = parse(response, startRule, endRule);
		book.setAuthor(author);

		startRule = "<original_publication_year";
		String publicationYearString = parse(response, startRule, endRule);
		int publicationYear = Integer.valueOf(publicationYearString);
		book.setPublicationYear(publicationYear);

		startRule = "<average_rating";
		String averageRatingString = parse(response, startRule, endRule);
		Double averageRating = Double.parseDouble(averageRatingString);
		book.setAverageRating(averageRating);

		startRule = "<ratings_count";
		String ratingsCountString = parse(response, startRule, endRule);
		ratingsCountString = ratingsCountString.replaceAll(",", "");
		int ratingsCount = Integer.valueOf(ratingsCountString);
		book.setRatingsCount(ratingsCount);

		startRule = "<image_url";
		String imageUrl = parse(response, startRule, endRule);
		book.setImageUrl(imageUrl);

		return book;
	}

	private static String parse(String response, String startRule,
			String endRule) {

		String responseString = response.substring(
				response.indexOf(startRule) + 1,
				response.indexOf(endRule + "/" + startRule.substring(1)));

		String responseValue = responseString.substring(responseString
				.indexOf(">") + 1);

		return responseValue;
	}

	public static void main(String[] args) {
		String response = "<work>"
				+ "<id type=\"integer\">2361393</id>"
				+ "<books_count type=\"integer\">813</books_count>"
				+ "<ratings_count type=\"integer\">1,16,315</ratings_count>"
				+ "<text_reviews_count type=\"integer\">3439</text_reviews_count>"
				+ "<original_publication_year type=\"integer\">1854</original_publication_year>"
				+ "<original_publication_month type=\"integer\" nil=\"true\"/>"
				+ "<original_publication_day type=\"integer\" nil=\"true\"/>"
				+ "<average_rating>3.79</average_rating>"
				+ "<best_book type=\"Book\">"
				+ "<id type=\"integer\">16902</id>" + "<title>Walden</title>"
				+ "<author>" + "<id type=\"integer\">10264</id>"
				+ "<name>Henry David Thoreau</name>" + "</author>"
				+ "<image_url>"
				+ "http://images.gr-assets.com/books/1465675526m/16902.jpg"
				+ "</image_url>" + "<small_image_url>"
				+ "http://images.gr-assets.com/books/1465675526s/16902.jpg"
				+ "</small_image_url>" + "</best_book>" + "</work>";

		Book book = APIResponseParser.parse(response);
		System.out.println(book);
	}
}