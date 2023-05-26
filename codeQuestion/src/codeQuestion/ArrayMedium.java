package codeQuestion;

import java.util.Arrays;
import java.util.OptionalDouble;

public class ArrayMedium {

	public static void main(String[] args) {


		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		double answer = solution(array);
		
		int[] array2 = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
		double answer2 = solution(array2);
		
		System.out.println(answer);
		System.out.println(answer2);
		
		System.out.println(solution2(array));


	}

	/**
	 * 정수 배열 numbers가 매개변수로 주어집니다. 
	 * numbers의 원소의 평균값을 return하도록 solution 함수를 완성해주세요..
	 * numbers = result
	 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] = 5.5
	 * [89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99] = 94.0
	 * 
	 * @param numbers
	 * @return
	 */
	public static double solution(int[] numbers) {
		double answer = 0;
		int arrayLength = numbers.length;
		for (int number : numbers) {
			answer += number;
		};
		answer = answer / arrayLength;

		return answer;
	}
	
	public static double solution2(int[] numbers) {
		return Arrays.stream(numbers).average().getAsDouble();
	}

}
