package codeQuestion;

public class Babbling {

	public static void main(String[] args) {

		Babbling bb = new Babbling();

		String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
		System.out.println(bb.solution(babbling));

	}

	public int solution(String[] babbling) {
		int answer = 0;
		String[] originBabbling = { "aya", "ye", "woo", "ma" };
		int originBabblingLength = originBabbling.length;
		int babblingLength = babbling.length;
		
		for(int i = 0; i < babblingLength; i++) {
			for(int j = 0; j < originBabblingLength; j++) {
				babbling[i] = babbling[i].replaceAll(originBabbling[j], "!");
			}
			babbling[i] = babbling[i].replaceAll("!", "");
			
			if(babbling[i].equals("")) {
				answer++;
			}
		}
		
		return answer;
	}
}
