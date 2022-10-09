//$Id$
package Jeslin;

public class HeartPattern {

	private static void printSpace(int count) {
		for(int i=0;i<count;i++) {
			System.out.print(" ");
		}
	}

	private static void printStar(int count) {
		for(int i=0;i<count;i++) {
			System.out.print("*");
		}
	}

	private static void heart(int length) {
//		2,5,5,5,2
//		1,7,3,7,1
//		0,9,1,9,0
//		0,19
//		1,17
//		2,15
		int n= length/4;
		for(int row =n/2; n<=length/2; row--) {
			int between = length - ((2*n)+(2*row));
			printSpace(row);
			printStar(n);
			printSpace(between);
			printStar(n);
			printSpace(row);
			System.out.println();
			n+=2;
		}

		for(int j=0;j<=length/2;j++) {
			printSpace(j);
			printStar(length-(2*j));
			System.out.println();
		}
		System.out.println();
	}

	private static void justBeat(int length) {
//		2,5,5,5,2
//		1,7,3,7,1
//		0,9,1,9,0
//		0,19
//		1,17
//		2,15
		int n= length/4;
		for(int row =n/2; n<=length/2; row--) {
			int between = length - ((2*n)+(2*row));
			printSpace(row);
			printStar(n);
			printSpace(between);
			printStar(n);
			printSpace(row);
			System.out.println();
			n+=2;
		}

		for(int j=0;j<=length/2;j++) {
			printSpace(j);
			if(j==0) {
				for(int i=0;i<length;i++) {
					if(i==length/6) {
						System.out.print("Sabari");
						i+=6;
					}
					if(i==(length-(length/3))){
						System.out.print("jeslin");
						i+=6;
					}
					System.out.print("*");
				}
			}else {
				printStar(length-(2*j));
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//Give Input only odd numbers
		heart(27);
	}
}
