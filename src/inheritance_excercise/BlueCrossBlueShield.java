package inheritance_excercise;

public class BlueCrossBlueShield implements InsuranceBrand {
	private long id;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double computeMonthlyPremium(HealthInsurancePlan insurancePlan,
			int age, boolean smoking) {

		double additionalAmount = 0.0;

		if (insurancePlan instanceof PlatinumPlan) {
			if (age >= 55) {
				if (smoking) {
					additionalAmount += 300;
				} else {
					additionalAmount += 200;
				}
			}
			if (age < 55) {
				if (smoking) {
					additionalAmount += 100;
				} else {
					additionalAmount = 0.0;
				}
			}
		} else if (insurancePlan instanceof GoldPlan) {
			if (age >= 55) {
				if (smoking) {
					additionalAmount += 240;
				} else {
					additionalAmount += 150;
				}
			}
			if (age < 55) {
				if (smoking) {
					additionalAmount += 90;
				} else {
					additionalAmount = 0.0;
				}
			}
		} else if (insurancePlan instanceof SilverPlan) {
			if (age >= 55) {
				if (smoking) {
					additionalAmount += 180;
				} else {
					additionalAmount += 100;
				}
			}
			if (age < 55) {
				if (smoking) {
					additionalAmount += 80;
				} else {
					additionalAmount = 0.0;
				}
			}
		} else if (insurancePlan instanceof BronzePlan) {
			if (age >= 55) {
				if (smoking) {
					additionalAmount += 120;
				} else {
					additionalAmount += 50;
				}
			}
			if (age < 55) {
				if (smoking) {
					additionalAmount += 70;
				} else {
					additionalAmount = 0.0;
				}
			}
		}

		return additionalAmount;
	}
}
