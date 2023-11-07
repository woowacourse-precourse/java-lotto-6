package lotto.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
	public List<List<Integer>> myLotto = new ArrayList<List<Integer>>();

	public RandomGenerator(int number) {
		
		for(int i=0; i < number; i++) {
			List<Integer> numbers = new ArrayList<>();
			numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(numbers);
			myLotto.add(numbers);
		}
    }
	
	public void print() {
		int size = myLotto.size();
		System.out.println(size + "개를 구매했습니다.");
		for(int i = 0; i < size; i++) {
			System.out.println(myLotto.get(i));
		}
	}
}
