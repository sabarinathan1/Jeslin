//$Id$
package Jeslin;

import java.util.Scanner;

public class EB_Bill_Calculator {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		System.out.println("Enter number of inputs : ");
		int n = in.nextInt();
		long arr[] = new long[n];
		for(int i=0; i<n; i++) {
			System.out.println(i+") Enter Units : ");
			long unit = in.nextLong();
			arr[i] = unit;
		}
		// int arr[] = new int[] {510,570, 530, 500, 730, 590};
		double totalPerYear = 0;
		double oldTotal = 0;
		String line = "-------------------------------------------------------------------------------------------";
		System.out.println(line);
		System.out.printf("| %15s | %15s | %15s | %15s | %15s | \n", "Months", "Units"," Old Price(Rs)","New Price(Rs)","Hike");
		System.out.println(line);
		int month = 1;
		for(int i=0; i<arr.length; i++) {
			double oldMonthlyCharge = unitsToPrice2021(arr[i]);
			double newMonthlyCharge = unitsToPrice2022(arr[i]);
			System.out.format("| %15s | %15s | %15s | %15s | %15s |\n", (month++)+","+(month++),arr[i],oldMonthlyCharge,newMonthlyCharge,(newMonthlyCharge - oldMonthlyCharge));
			System.out.println(line);
			totalPerYear += newMonthlyCharge;
			oldTotal += oldMonthlyCharge;
		}
		System.out.println("\nYearly total Cost: \n\tFor year 2021 - Rs."+oldTotal+"\n\tFor year 2022 - Rs." +totalPerYear);
		System.out.println("\nYearly avg Cost: \n\tFor year 2021 - Rs."+(oldTotal/arr.length) +"\n\tFor year 2022 - Rs."+(totalPerYear/arr.length));
	}

	private static double unitsToPrice2021(long units) {
		if(units<=100) {
			return 0;
		}
		if(units > 100 && units <=200) {
			//20 - fixed price
			return ((units - 100) * 1.5) + 20;
		}
		if(units > 200 && units <= 500) {
			//200 - (price for 101 unit to 200 units) 
			//30 - default charge
			return ((units - 200) * 3.0) + 200 + 30;
		}
		if(units > 500) {
			//350 - (price for 101 unit to 200 units) 
			//1380 - (price for 201 to 500 units)
			//50 - default charge
			return  ((units - 500) * 6.6) + 350 + 1380 + 50;
		}
		return -1;
	}

	private static double unitsToPrice2022(long units) {
		if(units <= 100) {
			return 0;
		}
		if(units > 100 && units <=200) {
			return ((units - 100) * 2.25);
		}
		if(units > 200 && units <= 400) {
			return ((units - 200) * 4.50) + 225;
		}
		if(units > 400 && units <= 500) {
			return ((units - 400) * 6.0) + 900 + 225;
		}
		if(units > 500 && units <= 600) {
			return ((units - 500) * 8.0) + 600 + 1350;
		}
		if(units > 600 && units <= 800) {
			return ((units - 600) * 9.0) + 800 + 600 + 1350;
		}
		if(units > 800 && units <= 1000) {
			return ((units-800) * 10.0) + 1800 + 800 + 600 + 1350;
		}
		if(units > 1000) {
			return ((units - 1000) * 11.0) + 2000 + 1800 + 800+ 600 + 1350;
		}
		return -1;
	}

}