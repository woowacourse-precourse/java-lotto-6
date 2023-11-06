package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.utils.Utils;

public class Service {
	
	private static final int LOTTO_START_INCLUSIVE = 1;
	private static final int LOTTO_END_INCLUSIVE = 45;
	private static final int LOTTO_SIZE = 6;
	
	public Lotto generateLotto() {
		List<Integer> numbers = Utils.generateUniqueNumberListInRange(LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE, LOTTO_SIZE);
		Utils.sortListAscendingOrder(numbers);
		return new Lotto(numbers);
	}

}
