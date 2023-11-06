package lotto.generate;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
	public static List<List<Integer>> myLotto;

	public RandomGenerator(int number) {
		
		for(int i=0; i < number; i++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			myLotto.add(numbers);
		}
    }
	
	public void print() {
		//발행한 로또 출력
	}

}
