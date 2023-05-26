package codeQuestion;

import java.util.Arrays;

public class GetMedian {

	public static void main(String[] args) {
		
		int[] array = {3, 9, 4, 7, 0, 1, 5, 8, 6, 2};
		int[] array2 = {9, -1, 0};
		int[] array3 = {1, 2, 7, 10, 11};
		int[] array4 = {1, 2, 3, 4, 5};
		
		System.out.println(solution(array));
		System.out.println();
		System.out.println(solution(array2));
		System.out.println();
		System.out.println(solution(array3));
		System.out.println();
		System.out.println(solution(array4));
		
		
	}

	/**
	 * 중앙값은 어떤 주어진 값들을 크기의 순서대로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다. 
	 * 예를 들어 1, 2, 7, 10, 11의 중앙값은 7입니다. 정수 배열 array가 매개변수로 주어질 때, 
	 * 중앙값을 return 하도록 solution 함수를 완성해보세요.
	 * @param numbers
	 * @return
	 */
	public static int solution(int[] numbers) {
		int answer = 0;
		
//		순서대로 배열
//		n+1/2
		quickSort(numbers, 0, numbers.length - 1);
		System.out.println(Arrays.toString(numbers));
		answer =  numbers[numbers.length / 2];
		
		return answer;
	}
	
	public static void quickSort(int[] array, int start, int end) {
		int partNum = partition(array, start, end);
		if(start < partNum - 1) {
			quickSort(array, start, partNum - 1);
		}
		if(partNum < end) {
			quickSort(array, partNum, end);
		}
	}
	
	public static int partition(int[] array, int start, int end) {
		int pivot = array[(start + end) / 2];
		while(start <= end) {
			while(array[start] < pivot) {
				start++;
			}
			while(array[end] > pivot) {
				end--;
			}
			if(start <= end) {
				swap(array, start, end);
				start++;
				end--;
			}	
		}
		return start;
	}
	
	public static void swap(int[] array, int start, int end) {
		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	}

}
