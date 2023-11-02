package lotto.generator;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoNumberGenerator implements Generator<List<Integer>> {

	@Override
	public List<Integer> generate() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LOTTO_SIZE);
		Collections.sort(numbers);
		return numbers;
	}
}
