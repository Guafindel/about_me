package codeQuestion;

import java.util.Arrays;

public class FractionSum {

	public static void main(String[] args) {

		FractionSum fs = new FractionSum();
		System.out.println(Arrays.toString(fs.solution(1, 2, 3, 4)));
	}

	public int[] solution(int denum1, int num1, int denum2, int num2) {
		int answer[] = new int[2];
		
		int numerator = (denum1*num2) + (denum2*num1);
		int denominator = num1*num2;
		
//		int factor1 = numerator;
//		int factor2 = denominator;
//		int remainder = factor1%factor2;
//		int maxCommonFactor = 0;
//		
//		while(remainder != 0) {
//			factor1 = factor2;
//			factor2 = remainder;
//			remainder = factor1%factor2;
//		}
//		maxCommonFactor = factor2;
		
		int maxCommonFactor = maxCommonFactor(numerator, denominator);

		answer[0] = numerator/maxCommonFactor;
		answer[1] = denominator/maxCommonFactor;

		return answer;
	}
	
	public int maxCommonFactor(int num1, int num2) {
		if(num2 == 0) {
			return num1;
		} else {
			return maxCommonFactor(num2, num1%num2);
		}
	}

}
