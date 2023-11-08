package lotto.service;

import static lotto.domain.Customer.*;
import static lotto.provider.LottoInputProvider.*;

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

}
