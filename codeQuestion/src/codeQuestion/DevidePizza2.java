package codeQuestion;

public class DevidePizza2 {

	public static void main(String[] args) {

		System.out.println(solution2(10));
		
		System.out.println(12/4);

	}
	
	// 최대공약수 GCD(Greatest Common Divisor) 최대공약수는 두 자연수의 공통된 약수 중 가장 큰 수를 의미한다.
	// ex) 72 와 30의 최대공약수는 6이다.
	//
	// 최소공배수 LCM(Least Common Multiple) 최소공배수는 두 자연수의 공통된 배수 중 가장 작은 수를 의미한다.
	// 최소공배수 = 두 자연수의 곱 / 최대공약수
	// ex) 72 와 30의 최소공배수는 360이다.
	//

	//	우클리드 호제법 정의
	//	2개의 자연수  a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면 (단 a>b), 
	//	a와 b의 최대공약수는 b와 r의 최대공약수와 같다. 
	//	이 성질에 따라, b를 r로 나눈 나머지 r0를 구하고, 
	//	다시 r을 r0로 나눈 나머지를 구하는 과정을 반복하여 
	//	나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다. 
	//	이는 명시적으로 기술된 가장 오래된 알고리즘으로서도 알려져 있으며, 
	//	기원전 300년경에 쓰인 유클리드의 <원론> 제7권, 명제 1부터 3까지에 해당한다.

	/**
	 * 머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때, n명이 주문한 피자를 남기지
	 * 않고 모두 같은 수의 피자 조각을 먹어야 한다면 최소 몇 판을 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
	 * 
	 * @param numbers
	 * @return
	 */
	public static int solution(int n) {
		int answer = 6;

		while (answer % n != 0) {
			answer += 6;
		}

		return answer / 6;
	}

	public static int solution2(int n) {
		int answer = 0;
		
		//(먹는 인원수, 한판당 피자의 조각 수) / 한판단 피자의 조각 수 = 필요한 피자 판 수
		answer = lcm(n, 6) /6;
		
		return answer;
	}

	/**
	 * 최대공약수
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int gdc(int num1, int num2) {
		if(num2 == 0) {
			return num1;
		} else {
			return gdc(num2, num1%num2);
		}
	}
	
	/**
	 * 최소공배수
	 * 두 자연수의 곱 / 최대공약수
	 * @return
	 */
	public static int lcm(int num1, int num2) {
		return num1*num2 / gdc(num1, num2);
	}

}
