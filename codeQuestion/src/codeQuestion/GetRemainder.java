package codeQuestion;

public class GetRemainder {

	public static void main(String[] args) {
		
		GetRemainder gr = new GetRemainder();
		
		System.out.println(gr.solution(7, 2));
	}
	
	public int solution(int num1, int num2) {
	    int answer = num1%num2;
	    return answer;
	}

}
