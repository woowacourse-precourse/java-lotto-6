package lotto.calculator;

import java.util.EnumMap;
import java.util.Map;

import lotto.domain.LottoRank;

public final class LottoCalculator implements Calculator<Integer, EnumMap<LottoRank, Integer>> {

	private static final int PERCENTAGE = 100;

	@Override
	public Integer calculateSum(EnumMap<LottoRank, Integer> lottoRanks) {
		int lottoPriceSum = 0;

		for (Map.Entry<LottoRank, Integer> entry : lottoRanks.entrySet()) {
			LottoRank lottoRank = entry.getKey();
			int number = entry.getValue();

			lottoPriceSum += lottoRank.getLottoPrice() * number;
		}

		return lottoPriceSum;
	}

	@Override
	public Double calculateRate(Integer money, Integer lottoPriceSum) {
		return (double) lottoPriceSum / (double) money * PERCENTAGE;
	}
}