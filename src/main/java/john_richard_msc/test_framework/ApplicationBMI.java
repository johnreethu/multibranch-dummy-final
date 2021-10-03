package john_richard_msc.test_framework;

import java.util.Scanner;

public class ApplicationBMI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Provide the Name: ");		
		String name = scanner.nextLine();
		System.out.println("Weight: ");		
		double weight = scanner.nextDouble();
		System.out.println("Height: ");		
		double height = scanner.nextDouble();		
		ApplicationBMI application = new ApplicationBMI();
		Result result = application.getBMIResult(name, weight, height);
		StringBuilder report = new StringBuilder();
		report.append(result.getName());
		report.append(result.getBmi());
		report.append(result.getStatus());
		System.out.println(report.toString());
		scanner.close();
	}
	
	/**
	 * This function calculate the BMI based on provided weight and height
	 * @param weight in Kilogram
	 * @param height in Feet
	 * @return BMI value {@link Double}
	 */
	protected double calculateBMI(double weight, double height) {
		try{
			height = convertToMeter(height);			
		    double BMI = weight / (height * height);
		    System.out.print("\nThe Body Mass Index (BMI) is " + BMI + " kg/m2");
			return BMI;	
		} catch(Exception e) {
			return 0;
		}
	}

	protected double convertToMeter(double height) {
		if(height < 0.0) {
			return 0.0;
		} else 
			return height * 0.3048;
	}

	protected Result getBMIResult(String name, double weight, double height) {
		Result result = new Result();
		try{
			result.setName(name);
			result.setBmi(this.calculateBMI(weight, height));
			result.setStatus(this.getBMIStatus(result.getBmi()));
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	protected String getBMIStatus(double bmi) {
		if(bmi > 0.0 && bmi <= 18.5) {
			return "underweight";
		}
		if(bmi > 18.5 && bmi <= 24.9) {
			return "normal";
		}
		if(bmi > 24.9 && bmi <= 29.9) {
			return "overweight";
		}
		if(bmi >= 30.0) {
			return "Obese";
		} else {
			return "Invalid BMI Value "+bmi;
		}
	}
}
