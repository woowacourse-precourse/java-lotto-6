package lotto.model;

import lotto.util.Constant;
import lotto.util.Format;

import java.util.List;

public class YieldManager {
	public static float makeYield(List<Ranking> prize) {
		float beforeMoney = prize.size() * Constant.LOTTO_PRICE;
		float totalMoney = beforeMoney;

		for (Ranking ranking : prize) {
			totalMoney += ranking.getRank();
		}
		return Format.calculateYield(totalMoney, beforeMoney);
	}
}
