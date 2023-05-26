package codeQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class HateEven {

	public static void main(String[] args) {
		
		solution(15);
		solution2(15);
		
	}

	/**
	 * 정수 n이 매개변수로 주어질 때, 
	 * n 이하의 홀수가 오름차순으로 담긴 배열을 
	 * return하도록 solution 함수를 완성해주세요.
	 * @param numbers
	 * @return
	 */
	public static int[] solution(int num) {
		List<Integer> oddList = new ArrayList<Integer>();
		
		for(int i = 1; i <= num; i++) {
			if(i % 2 != 0) {
				oddList.add(i);
			}
		}
		
		int[] answer = new int[oddList.size()];
		
		int oddCnt = 0;
		
		for (Integer odd : oddList) {
			answer[oddCnt] = odd;
			oddCnt++;
		}
		
		return answer;
	}
	
	/**
	 * 정수 n이 매개변수로 주어질 때, 
	 * n 이하의 홀수가 오름차순으로 담긴 배열을 
	 * return하도록 solution 함수를 완성해주세요.
	 * @param numbers
	 * @return
	 */
	public static int[] solution2(int num) {
		
		int[] answer = IntStream.rangeClosed(0, num).filter(e -> e % 2 != 0).toArray();
		
		return answer;
	}

}
