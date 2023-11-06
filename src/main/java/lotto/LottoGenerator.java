package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
	public List<Integer> generateDeduplicationNumbers() {
		List<Integer> numbers = new ArrayList<>();
		numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

		return numbers;
	}

	public List<Integer> sortNumbers(List<Integer> numbers) {
		Collections.sort(numbers);
		return numbers;
	}

}
