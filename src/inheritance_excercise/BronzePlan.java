package inheritance_excercise;

public class BronzePlan extends HealthInsurancePlan {
	private double coverage;

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage() {
		this.coverage = 0.6;
	}

	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		return 0.05 * salary
				+ getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
