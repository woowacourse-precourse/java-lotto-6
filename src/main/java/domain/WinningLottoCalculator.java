package domain;

import java.text.DecimalFormat;
import java.util.HashMap;

public class WinningLottoCalculator {
	private final HashMap<LottoPrize, Integer> lottoPrizes;
	private Long totalPrizeMoney;

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

	public Long getTotalPrizeMoney() {
		return totalPrizeMoney;
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

		plusTotalPrizeMoney(lottoPrizeType);
	}

	private void plusTotalPrizeMoney(LottoPrize lottoPrizeType) {
		this.totalPrizeMoney += lottoPrizeType.getPrizeMoney();
	}

	public double getRateOfReturn(PurchaseAmount purchaseAmount) {
		return roundToTwoDecimalPlaces((((double)this.totalPrizeMoney) / purchaseAmount.getAmount()) * 100);
	}

	public double roundToTwoDecimalPlaces(double rateOfReturn) {
		DecimalFormat decimalFormat = new DecimalFormat("#.#");
		return Double.parseDouble(decimalFormat.format(rateOfReturn));
	}

	public String createWinningLottoMessage(LottoPrize lottoPrize) {
		if (lottoPrize == LottoPrize.SECOND_PRIZE) {
			return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", lottoPrize.getMatchCount(),
					lottoPrize.getPrizeMoney(), lottoPrizes.get(lottoPrize));
		}
		return String.format("%d개 일치 (%,d원) - %d개", lottoPrize.getMatchCount(), lottoPrize.getPrizeMoney(),
				lottoPrizes.get(lottoPrize));
	}
}
