package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {

	public LottoGenerator() {
	}

	public List<Integer> generateDeduplicationNumbers() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

		return numbers;
	}

	public List<Integer> sortNumbers(List<Integer> numbers) {
		List<Integer> sortedNumbers = new ArrayList<>(numbers);
		Collections.sort(sortedNumbers);
		return sortedNumbers;
	}

	public Lotto generateLotto() {
		List<Integer> generatedLottoNumbers = generateDeduplicationNumbers();
		List<Integer> sortedNumbers = sortNumbers(generatedLottoNumbers);
		return new Lotto(sortedNumbers);
	}

}
