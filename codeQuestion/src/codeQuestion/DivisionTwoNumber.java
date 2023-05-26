package codeQuestion;

public class DivisionTwoNumber {

	public static void main(String[] args) {

		DivisionTwoNumber dtn = new DivisionTwoNumber();
		System.out.println(dtn.solution(7, 3));
	}
	
	public int solution(int num1, int num2) {
        int answer = (int)((double)num1/num2 * 1000);
        return answer;
    }

}
