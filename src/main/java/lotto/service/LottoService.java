package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

import lotto.calculator.LottoCalculator;
import lotto.domain.AnswerLotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.generator.LottosGenerator;
import lotto.util.message.WinningStatisticsMessage;

public class LottoService {

	private static final LottosGenerator GENERATOR = new LottosGenerator();
	private static final LottoCalculator calculator = new LottoCalculator();
	private static final String DELIMITER = System.lineSeparator();

	public Lottos createLottos() {
		return new Lottos(GENERATOR.generate());
	}

	public void setMoney(Money money) {
		GENERATOR.setMoney(money);
	}

	public AnswerLotto createAnswerLotto(List<Integer> numbers, int bonusNumber) {
		return new AnswerLotto(numbers, bonusNumber);
	}

	public int calculateLottoPriceSum(Lottos lottos, AnswerLotto answerLotto) {
		EnumMap<LottoRank, Integer> lottRankCounter = countLottoRank(lottos, answerLotto);
		return calculator.calculateSum(lottRankCounter);
	}

	public double calculateTotalReturn(int money, int priceSum) {
		return calculator.calculateTotalReturn(money, priceSum);
	}

	public String getWinningStatisticsMessage(Lottos lottos, AnswerLotto answerLotto) {
		StringJoiner strJoiner = new StringJoiner(DELIMITER);
		Set<Entry<LottoRank, Integer>> lottRankCounter = countLottoRank(lottos, answerLotto).entrySet();

		for (Map.Entry<LottoRank, Integer> entry : lottRankCounter) {
			LottoRank key = entry.getKey();
			int value = entry.getValue();
			boolean isBonusNumber = key.getisBonusNumber();

			if (key != LottoRank.NOTHING) {
				strJoiner.add(getFormattedMessage(isBonusNumber, key, value));
			}
		}

		return strJoiner.toString();
	}

	private EnumMap<LottoRank, Integer> countLottoRank(Lottos lottos, AnswerLotto answerLotto) {
		EnumMap<LottoRank, Integer> lottRankCounter = LottoRank.toEnumMap();

		lottos.getLottos().stream().map(lotto -> LottoRank.getMatchedLottoRank(answerLotto, lotto))
				.filter(Objects::nonNull)
				.forEach(lottoRank -> lottRankCounter.put(lottoRank, lottRankCounter.get(lottoRank) + 1));

		return lottRankCounter;
	}

	private String getFormattedMessage(boolean isBonusNumber, LottoRank rank, int count) {
		WinningStatisticsMessage message = filterMessage(isBonusNumber);
		return message.getForMatMessage(rank.getMatchedNumCount(), rank.getPrice(), count);
	}

	private WinningStatisticsMessage filterMessage(boolean isBonusNumber) {
		if (isBonusNumber) {
			return WinningStatisticsMessage.HAVE_BONUS_NUMBER;
		}

		return WinningStatisticsMessage.DONT_HAVE_BONUS_NUMBER;
	}
}
