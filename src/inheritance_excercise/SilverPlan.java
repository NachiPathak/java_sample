package inheritance_excercise;

public class SilverPlan extends HealthInsurancePlan {
	private double coverage;

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage() {
		this.coverage = 0.7;
	}

	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		return 0.06 * salary
				+ getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
