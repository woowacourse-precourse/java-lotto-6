package lotto.service;

import java.util.List;

import lotto.domain.LottoRank;
import lotto.domain.Money;

public class CalculateLottoPriceService {

	public double getTotalReturn(List<LottoRank> lottoRanks, Money orginMoney) {
		int priceSum = getPriceSum(lottoRanks);
		int money = orginMoney.getMoney();

		return (double) priceSum / (double) money * 100;
	}

	protected int getPriceSum(List<LottoRank> lottoRanks) {
		return lottoRanks.stream().mapToInt(LottoRank::getPrice)
						.sum();
	}
}
