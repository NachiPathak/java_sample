package inheritance_excercise;

public class Billing {
	public static double[] computePaymentAmount(Patient patient, double amount) {
		double[] payments = new double[2];
		double companyShare = 0.0;
		double patientShare = 0.0;

		HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

		if (patientInsurancePlan instanceof PlatinumPlan) {
			companyShare = (0.9) * amount;
			patientShare = amount - companyShare - 50;
			// patientShare -= 50;
		} else if (patientInsurancePlan instanceof GoldPlan) {
			companyShare = (0.8) * amount;
			patientShare = amount - companyShare;
			patientShare -= 40;
		} else if (patientInsurancePlan instanceof SilverPlan) {
			companyShare = (0.7) * amount;
			patientShare = amount - companyShare;
			patientShare -= 30;
		} else if (patientInsurancePlan instanceof BronzePlan) {
			companyShare = (0.6) * amount;
			patientShare = amount - companyShare;
			patientShare -= 25;
		} else {
			companyShare = 0.0;
			patientShare = amount;
			patientShare -= 20;
		}
		payments[0] = companyShare;
		payments[1] = patientShare;

		return payments;
	}

	public static void main(String[] args) {
//		HealthInsurancePlan insurancePlan = new PlatinumPlan();
//		Patient patient = new Patient();
//		patient.setInsurancePlan(insurancePlan);
//
//		double billedAmount = 1000.0;
//		double[] payments = Billing.computePaymentAmount(patient, billedAmount);
//
//		System.out.println("Total Billed Amount = " + billedAmount
//				+ "\nCompany's Share = " + payments[0] + "\nPatient's Share = "
//				+ payments[1]);
//		
//		System.out.println("Platinum Plan Premium is " + insurancePlan.computeMonthlyPremium(800.0, 56, true));

		User staff = new User();                        
		InsuranceBrand insuranceBrand = new BlueCrossBlueShield();           
		HealthInsurancePlan insurancePlan = new PlatinumPlan(); 
		 
		insurancePlan.setOfferedBy(insuranceBrand);
		staff.setInsurancePlan(insurancePlan);
		System.out.println("Platinum Plan Premium is " + insurancePlan.computeMonthlyPremium(8000, 55, false));

	}
}
