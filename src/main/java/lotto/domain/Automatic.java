package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Automatic {

	public static List<List<Integer>> issuance(int lottoCount) {

		List<List<Integer>> lottoNumbers = new ArrayList<>();

		for (int i = 0; i < lottoCount; i++) {
			List<Integer> lottoNumber = publish();
			lottoNumbers.add(lottoNumber);
		}
		return lottoNumbers;
	}

	public static List<Integer> publish() {

		List<Integer> numbers = new ArrayList<>();

		while (numbers.size() < 6) {
			List<Integer> number = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			if (numbers.contains(number)) {
				continue;
			} else {
				numbers.addAll(number);
			}
		}

		return numbers;

	}

}
