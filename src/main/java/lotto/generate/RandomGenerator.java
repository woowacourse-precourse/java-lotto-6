package lotto.generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
	public List<List<Integer>> myLotto = new ArrayList<List<Integer>>();

	public RandomGenerator(int number) {
		
		for(int i=0; i < number; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(numbers);
			myLotto.add(numbers);
		}
    }
	
	public void print() {
		for(int i = 0; i < myLotto.size(); i++) {
			System.out.println(myLotto.get(i));
		}
	}

}
