package lotto.calculator;

import java.util.EnumMap;
import java.util.Map;

import lotto.domain.LottoRank;

public final class LottoCalculator implements Calculator<Integer, EnumMap<LottoRank, Integer>> {

	@Override
	public Integer calculateSum(EnumMap<LottoRank, Integer> lottoRanks) {
		int priceSum = 0;

		for (Map.Entry<LottoRank, Integer> entry : lottoRanks.entrySet()) {
			LottoRank lottoRank = entry.getKey();
			int number = entry.getValue();

			priceSum += lottoRank.getPrice() * number;

		}

		return priceSum;
	}

	@Override
	public Double calculateTotalReturn(Integer money, Integer priceSum) {
		return (double) priceSum / (double) money * 100;
	}
}
