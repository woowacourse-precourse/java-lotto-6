package lotto;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

import lotto.domain.AnswerLotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.util.message.WinningStatisticsMessage;

public class LotteryStatistician {

	private static final String DELIMITER = System.lineSeparator();

	private final Money orginMoney;
	private final Lottos lottos;
	private final AnswerLotto answerLotto;

	public LotteryStatistician(Money orginMoney, Lottos lottos, AnswerLotto answerLotto) {
		this.orginMoney = orginMoney;
		this.lottos = lottos;
		this.answerLotto = answerLotto;
	}

	public double getTotalReturn() {
		int priceSum = getPriceSum();
		int money = orginMoney.getMoney();

		return (double) priceSum / (double) money * 100;
	}

	private int getPriceSum() {
		EnumMap<LottoRank, Integer> lottoRankCounter = countLottoRank();
		int priceSum = 0;

		for (Map.Entry<LottoRank, Integer> entry : lottoRankCounter.entrySet()) {
			LottoRank key = entry.getKey();
			int value = entry.getValue();

			priceSum += key.getPrice() * value;

		}

		return priceSum;
	}

	public String getWinningStatisticsMessage() {
		StringJoiner strJoiner = new StringJoiner(DELIMITER);

		for (Map.Entry<LottoRank, Integer> entry : countLottoRank().entrySet()) {
			LottoRank key = entry.getKey();
			int value = entry.getValue();
			boolean isBonusNumber = key.getisBonusNumber();

			if (key != LottoRank.NOTHING) {
				strJoiner.add(getFormattedMessage(isBonusNumber, key, value));
			}
		}
		return strJoiner.toString();
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

	private EnumMap<LottoRank, Integer> countLottoRank() {
		EnumMap<LottoRank, Integer> lottRankCounter = LottoRank.toEnumMap();

		lottos.getLottos().stream().map(lotto -> LottoRank.getMatchedLottoRank(answerLotto, lotto))
				.filter(Objects::nonNull)
				.forEach(lottoRank -> lottRankCounter.put(lottoRank, lottRankCounter.get(lottoRank) + 1));

		return lottRankCounter;
	}
}
