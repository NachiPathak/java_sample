package inheritance_excercise;

public class GoldPlan extends HealthInsurancePlan {
	private double coverage;

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage() {
		this.coverage = 0.8;
	}

	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		return 0.07 * salary
				+ getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
