package codeQuestion;

public class NumberCompare {
	
	public static void main(String[] args) {
		
		NumberCompare nbc = new NumberCompare();

		int answer = nbc.solution(10, 5);
		
		System.out.println(answer);
		
	}

	/**
	 * 정수 num1, num2가 매개변수로 주어질 때, 
	 * num1를 num2로 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int solution(int num1, int num2) {
        int answer = 0;
        answer = num1 == num2 ? 1: -1;
        return answer;
    }
	

}
