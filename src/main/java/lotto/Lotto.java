package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		
		CheckValid.numbers(numbers);
		
		this.numbers = numbers;
	}
	
	public List<Integer> getNumbers() {
		return numbers;
	}

	private static Lotto createRandomLotto() {
		
	    List<Integer> numbers = new ArrayList<>();
	    numbers.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6));
	    Collections.sort(numbers);
	    
		return new Lotto(numbers);
	}

	public static List<List<Integer>> create(int lottocount) {
		List<List<Integer>> lottos = new ArrayList<>();

		for (int i = 0; i < lottocount; i++) {
			Lotto lotto = createRandomLotto();
			lottos.add(lotto.getNumbers());
		}

		return lottos;
	}
}
