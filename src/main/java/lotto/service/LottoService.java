package lotto.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.ErrorType;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningRank;

public class LottoService {

	private static final int MIN_LOTTO_PRICE = 1000;

	public List<Lotto> purchaseLotto(int price) {
		validate(price);

		int lottoAmount = price / MIN_LOTTO_PRICE;

		return IntStream.range(0, lottoAmount)
			.mapToObj(i -> generateRandomLotto())
			.collect(Collectors.toList());
	}

	public List<LottoResult> checkWinning(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
		return lottos.stream()
			.map(lotto -> createLottoResult(lotto, winningNumbers, bonusNumber))
			.collect(Collectors.toList());
	}

	public Map<WinningRank, Integer> totalStatistics(List<LottoResult> lottoResults) {
		return lottoResults.stream()
			.collect(Collectors.groupingBy(LottoResult::getWinningRank, Collectors.summingInt(result -> 1)));
	}

	private LottoResult createLottoResult(Lotto lotto, Lotto winningNumbers, int bonusNumber) {
		return new LottoResult(compareLottoNumbers(lotto, winningNumbers),
			containsBonusNumber(lotto, bonusNumber));
	}

	private int compareLottoNumbers(Lotto lotto, Lotto winningNumbers) {
		return (int)lotto.getNumbers().stream()
			.filter(number -> winningNumbers.getNumbers().contains(number))
			.count();
	}

	private boolean containsBonusNumber(Lotto lotto, int bonusNumber) {
		return lotto.getNumbers().contains(bonusNumber);
	}

	private void validate(int price) {
		if (price < MIN_LOTTO_PRICE || price % MIN_LOTTO_PRICE != 0) {
			throw new IllegalArgumentException(ErrorType.INVALID_PURCHASE_ERROR.getErrorMessage());
		}
	}

	private Lotto generateRandomLotto() {
		return new Lotto(Randoms.pickUniqueNumbersInRange(
			Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.MAX_LOTTO_SIZE));
	}

}
