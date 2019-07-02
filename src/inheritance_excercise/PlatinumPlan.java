package inheritance_excercise;

public  class PlatinumPlan extends HealthInsurancePlan {
	private double coverage;

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage() {
		this.coverage = 0.9;
	}
	
	
	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		System.out.println("Additional  " + getOfferedBy());
		return 0.08 * salary
				+ getOfferedBy().computeMonthlyPremium(this, age, smoking);
}
}
