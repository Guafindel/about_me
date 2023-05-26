package codeQuestion;

public class MinusTwoNumber {

	public static void main(String[] args) {

		MinusTwoNumber mtn = new MinusTwoNumber();
		System.out.println(mtn.solution(100, 2));
	}
	
	public int solution(int num1, int num2) {
        int answer = num1 - num2;
        return answer;
    }

}
