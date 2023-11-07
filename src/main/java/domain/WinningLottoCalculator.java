package domain;

import java.util.HashMap;

public class WinningLottoCalculator {
	private final HashMap<LottoPrize, Integer> lottoPrizes;
	private double totalPrizeMoney;

	public WinningLottoCalculator() {
		this.lottoPrizes = new HashMap<>() {{
			put(LottoPrize.FIRST_PRIZE, 0);
			put(LottoPrize.SECOND_PRIZE, 0);
			put(LottoPrize.THIRD_PRIZE, 0);
			put(LottoPrize.FOURTH_PRIZE, 0);
			put(LottoPrize.FIFTH_PRIZE, 0);
			put(LottoPrize.BLANK, 0);
		}};

		this.totalPrizeMoney = 0L;
	}

	public HashMap<LottoPrize, Integer> getLottoPrizes() {
		return lottoPrizes;
	}

	public long getMatchCount(Lotto lotto, WinningLotto winningLotto) {
		return winningLotto.getWinningLotto()
				.getNumbers()
				.stream()
				.filter(lotto.getNumbers()::contains)
				.count();
	}

	public boolean isBonusNumberMatchLotto(Lotto lotto, WinningLotto winningLotto) {
		return lotto.getNumbers()
				.contains(winningLotto.getBonusNumber().getBonusNumber());
	}

	public void calculateLottoPrizeCount(PurchaseLotto purchaseLotto, WinningLotto winningLotto) {
		for (Lotto lotto : purchaseLotto.getLottos()) {
			long matchCount = getMatchCount(lotto, winningLotto);
			boolean bonusNumberMatchLotto = isBonusNumberMatchLotto(lotto, winningLotto);

			increaseLottoPrizes(matchCount, bonusNumberMatchLotto);
		}
	}

	private void increaseLottoPrizes(long matchCount, boolean bonusNumberMatchLotto) {
		LottoPrize lottoPrizeType = LottoPrize.getLottoPrizeType(matchCount, bonusNumberMatchLotto);
		lottoPrizes.put(lottoPrizeType, lottoPrizes.get(lottoPrizeType) + 1);
	}
}
