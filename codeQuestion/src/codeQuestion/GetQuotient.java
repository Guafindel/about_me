package codeQuestion;

public class GetQuotient {

	public static void main(String[] args) {
		
		GetQuotient gq = new GetQuotient();
		
		System.out.println(gq.solution(7, 2));
	}
	
	public int solution(int num1, int num2) {
	    int answer = num1/num2;
	    return answer;
	}

}
