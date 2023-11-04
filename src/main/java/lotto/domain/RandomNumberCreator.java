package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.NumberCreator;

public class RandomNumberCreator implements NumberCreator {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	private static final int SIZE = 6;

	@Override
	public List<Integer> create() {
		return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE);
	}

}
