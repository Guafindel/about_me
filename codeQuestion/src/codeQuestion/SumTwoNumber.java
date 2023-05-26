package codeQuestion;

public class SumTwoNumber {

	public static void main(String[] args) {
		
		SumTwoNumber stn = new SumTwoNumber();

		System.out.println(stn.solution(100, 2));
	}

	/**
	 * 정수 num1과 num2가 주어질 때, 
	 * num1과 num2의 합을 return하도록 soltuion 함수를 완성해주세요.
	 * @param common
	 * @return
	 */
	public int solution(int number1, int number2) {
        int answer = number1 + number2;
        return answer;
    }
	
}
