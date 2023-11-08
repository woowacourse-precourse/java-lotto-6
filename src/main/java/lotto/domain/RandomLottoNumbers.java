package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoNumbers {
	public List<Integer> makeRandomLottoNumbers() {
		List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		randomNumbers.sort(null);
		return randomNumbers;
	}
}

