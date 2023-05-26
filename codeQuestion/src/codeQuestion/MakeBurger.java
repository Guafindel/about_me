package codeQuestion;

import java.util.ArrayList;

public class MakeBurger {
	
	public static void main(String[] args) {

		MakeBurger mb = new MakeBurger();
		
		int[] ingredient = { 2, 2, 1, 2, 3, 1, 2, 1, 3, 2, 1, 2, 3, 3, 2, 2, 1, 3, 2, 1, 2 };

		System.out.println(mb.solution(ingredient));

	}

	public int solution(int[] ingredient) {
		ArrayList<Integer> s = new ArrayList<Integer>();
		int answer = 0;
		for (int i = 0; i < ingredient.length; i++) {
			s.add(ingredient[i]);
			if (s.size() >= 4 && s.get(s.size() - 1) == 1 && s.get(s.size() - 2) == 3 && s.get(s.size() - 3) == 2
					&& s.get(s.size() - 4) == 1) {
				s.remove(s.size() - 4);
				s.remove(s.size() - 3);
				s.remove(s.size() - 2);
				s.remove(s.size() - 1);
				answer++;
			}
		}
		return answer;
	}
}
