package codeQuestion;

import java.util.HashMap;
import java.util.Map;

public class GetMode {

	public static void main(String[] args) {
		
		int[] array = {1, 1, 1, 2, 3, 3, 3, 4};
		
		System.out.println(solution2(array));
		
	}

	/**
	 * 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다.
	 * 정수 배열 array가 매개변수로 주어질 때, 
	 * 최빈값을 return 하도록 solution 함수를 완성해보세요. 
	 * 최빈값이 여러 개면 -1을 return 합니다.
	 * @param numbers
	 * @return
	 */
	public static int solution(int[] array) {
		int answer = 0;
		
		int[] cntArray = new int[1001];
		int maxCnt = 0;
		int maxModeCnt = 0;
		
		
		for(int i = 0; i < array.length; i++) {
			cntArray[array[i]]++;
		}
		
		for(int i = 0; i < cntArray.length; i++) {
			if(cntArray[i] > maxCnt) {
				maxCnt = cntArray[i];
				answer = i;
			} else if (cntArray[i] == maxCnt) {
				answer = -1;
			}
		}
		
//		for(int i = 0; i < cntArray.length; i++) {
//			if(cntArray[i] == maxCnt) {
//				maxModeCnt++;
//			}
//		}
//		if(maxModeCnt > 1) {
//			answer = -1;
//		}
		
		return answer;
	}
	
	public static int solution2(int[] array) {
		int answer = 0;
		int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : array){
            int count = map.getOrDefault(number, 0) + 1;
            if(count > maxCount){
                maxCount = count;
                answer = number;
            }
            else  if(count == maxCount){
                answer = -1;
            }
            map.put(number, count);
        }
		return answer;
	}

}
