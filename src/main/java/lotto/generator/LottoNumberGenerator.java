package lotto.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public final class LottoNumberGenerator implements Generator<List<Integer>> {

	@Override
	public List<Integer> generate() {
		List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
				Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LOTTO_SIZE);
		List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);

		Collections.sort(sortedLottoNumbers);

		return sortedLottoNumbers;
	}
}