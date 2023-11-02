package lotto.service;

import java.util.stream.IntStream;

import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class CompareLottoNumbersService {

	public LottoRank getMatchedLottoRank(final AnswerLotto answerLotto, final Lotto lotto) {
		int winningNumberCount = getWinningNumberCount(answerLotto, lotto);

		boolean isBonusNumber = checkSameAsBonusNumber(answerLotto, lotto);

		return LottoRank.getLottoRank(winningNumberCount, isBonusNumber);
	}

	protected int getWinningNumberCount(final AnswerLotto answerLotto, final Lotto lotto) {
		return (int) IntStream.range(0, lotto.getSize())
				.filter(index -> answerLotto.isContain(lotto.getNumber(index)))
				.count();
	}

	protected boolean checkSameAsBonusNumber(final AnswerLotto answerLotto, final Lotto lotto) {
		return IntStream.range(0, lotto.getSize())
				.anyMatch(index -> answerLotto.getBonusNumber() == lotto.getNumber(index));
	}
}
