package codeQuestion;

public class ClothingStoreGetDiscount {

	public static void main(String[] args) {

		int answer = solution(150000);
		int answer2 = solution(580000);
		
		System.out.println(answer);
		System.out.println(answer2);

	}

	/**
	 * 머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인해줍니다.
	 * 구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.
	 * price	result
	 * 150,000	142,500
	 * 580,000	464,000
	 * @param numbers
	 * @return
	 */
	public static int solution(int price) {
		int answer = 0;
		
		if(price >= 500000) {
			answer = (int)(price * 0.8);
		} else if(price >= 300000) {
			answer = (int)(price * 0.90);
		} else if(price >= 100000) {
			answer = (int)(price * 0.95);
		} else {
			answer = price;
		}
		
//		if(100000 <= price && 300000 > price) {
//			answer = (price / 100) * 95;
//		} else if(300000 <= price && 500000 > price) {
//			answer = (price / 100) * 90;
//		} else if (500000 <= price) {
//			answer = (price / 100) * 80;
//		}
		
		return answer;
	}

}