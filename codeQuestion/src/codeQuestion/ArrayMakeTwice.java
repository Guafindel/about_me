package codeQuestion;

import java.util.Arrays;

public class ArrayMakeTwice {

	public static void main(String[] args) {

		ArrayMakeTwice amt = new ArrayMakeTwice();
		
		int[] arrays = {1, 2, 100, -99, 1, 2, 3};
		
		System.out.println(Arrays.toString(amt.solution(arrays)));
		
	}

	public int[] solution(int[] numbers) {
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i] * 2;
		}
		
		return numbers;
	}

}
