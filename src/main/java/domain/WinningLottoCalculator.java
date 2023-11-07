package domain;

import java.util.HashMap;

public class WinningLottoCalculator {
	private final HashMap<LottoPrize, Integer> lottoPrize;
	private double totalPrizeMoney;

	public WinningLottoCalculator() {
		this.lottoPrize = new HashMap<>();
		lottoPrize.put(LottoPrize.FIRST_PRIZE, 0);
		lottoPrize.put(LottoPrize.SECOND_PRIZE, 0);
		lottoPrize.put(LottoPrize.THIRD_PRIZE, 0);
		lottoPrize.put(LottoPrize.FOURTH_PRIZE, 0);
		lottoPrize.put(LottoPrize.FIFTH_PRIZE, 0);

		this.totalPrizeMoney = 0L;
	}

	public long getMatchCount(Lotto lotto, WinningLotto winningLotto) {
		return winningLotto.getWinningLotto()
				.getNumbers()
				.stream()
				.filter(lotto.getNumbers()::contains)
				.count();
	}
}
