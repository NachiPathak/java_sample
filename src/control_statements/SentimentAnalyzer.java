package control_statements;

import java.util.Arrays;

public class SentimentAnalyzer {
	// Tip: labeled continue can be used when iterating featureSet + convert
	// review to lower-case
	public static int[] detectProsAndCons(String review, String[][] featureSet,
			String[] posOpinionWords, String[] negOpinionWords) {
		int[] featureOpinions = new int[featureSet.length]; // output

		String[] reviews = review.split("!");
		int opinoin = 0;
		int count = 0;
		for (int k = 0; k < reviews.length; k++) {
			String reviewString = reviews[k];
			for (int i = 0; i < featureSet.length; i++) {

				for (int j = 0; j < featureSet[i].length; j++) {
					// for (int l = 0, m = 0; l < posOpinionWords.length
					// && m < negOpinionWords.length; l++, m++) {

					for (int l = 0; l < posOpinionWords.length; l++) {

						String feature = featureSet[i][j];
						String posOpinion = posOpinionWords[l];
						// String negOpinion = negOpinionWords[m];
						String negOpinion = "bad";

						String pattern1 = feature + " was";
						String pattern2 = posOpinion + " " + feature;

						if (reviewString.contains(pattern1)
								|| reviewString.contains(pattern2)) {
							if (reviewString.contains(feature)
									&& reviewString.contains(posOpinion)) {
								opinoin = 1;
								break;
							} else if (reviewString.contains(feature)
									&& reviewString.contains(negOpinion)) {
								opinoin = -1;
								break;
							}
						}
						System.out.println("Opition = " + opinoin);
					}
					featureOpinions[k] = opinoin;
				}

				opinoin = 0;

			}
			// count++;
		}

		/*
		 * for (int featureOpinion : featureOpinions) {
		 * System.out.println(featureOpinion); }
		 */
		// your code ~ you will be invoking getOpinionOnFeature

		return featureOpinions;
	}

	// First invoke checkForWasPhrasePattern and
	// if it cannot find an opinion only then invoke checkForOpinionFirstPattern
	private static int getOpinionOnFeature(String review, String feature,
			String[] posOpinionWords, String[] negOpinionWords) {
		return 0;

		// your code

	}

	// Tip: Look at String API doc. Methods like indexOf, length,
	// substring(beginIndex), startsWith can come into play
	// Return 1 if positive opinion found, -1 for negative opinion, 0 for no
	// opinion
	// You can first look for positive opinion. If not found, only then you can
	// look for negative opinion
	private static int checkForWasPhrasePattern(String review, String feature,
			String[] posOpinionWords, String[] negOpinionWords) {
		int opinion = 0;

		String pattern = feature + " was ";

		// your code

		return opinion;
	}

	// You can first look for positive opinion. If not found, only then you can
	// look for negative opinion
	private static int checkForOpinionFirstPattern(String review,
			String feature, String[] posOpinionWords, String[] negOpinionWords) {
		// Extract sentences as feature might appear multiple times.
		// split() takes a regular expression and "." is a special character
		// for regular expression. So, escape it to make it work!!
		String[] sentences = review.split("\\.");
		int opinion = 0;

		// your code for processing each sentence. You can return if opinion is
		// found in a sentence (no need to process subsequent ones)

		return opinion;
	}

	public static void main(String[] args) {
		String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";

		// String review =
		// "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

		String[][] featureSet = {
				{ "ambiance", "ambience", "atmosphere", "decor" },
				{ "dessert", "ice cream", "desert" },
				{ "food" },
				{ "soup" },
				{ "service", "management", "waiter", "waitress", "bartender",
						"staff", "server" } };
		String[] posOpinionWords = { "good", "fantastic", "friendly", "great",
				"excellent", "amazing", "awesome", "delicious" };
		String[] negOpinionWords = { "slow", "bad", "horrible", "awful",
				"unprofessional", "poor" };

		int[] featureOpinions = detectProsAndCons(review, featureSet,
				posOpinionWords, negOpinionWords);
		System.out.println("Opinions on Features: "
				+ Arrays.toString(featureOpinions));
	}
}