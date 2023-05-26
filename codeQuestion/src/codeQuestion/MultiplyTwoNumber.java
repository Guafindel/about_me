package codeQuestion;

public class MultiplyTwoNumber {

	public static void main(String[] args) {

		MultiplyTwoNumber mtn = new MultiplyTwoNumber();
		System.out.println(mtn.solution(100, 2));
	}
	
	public int solution(int num1, int num2) {
        int answer = num1 * num2;
        return answer;
    }

}
