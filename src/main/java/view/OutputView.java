package view;

import domain.Lotto;
import domain.LottoPrize;
import domain.PurchaseAmount;
import domain.WinningLottoCalculator;

public class OutputView {
	public static void printLotto(Lotto lotto) {
		System.out.println("[" + lotto.getLottoNumbersAsString() + "]");
	}

	public void printPurchaseAmount(PurchaseAmount purchaseAmount) {
		System.out.println(purchaseAmount.getLottoPurchaseCount() + "개를 구매했습니다.");
	}

	public void printLottoPrizes(WinningLottoCalculator winningLottoCalculator) {
		System.out.println("당첨 통계");
		System.out.println("---");
		for (LottoPrize lottoPrize : LottoPrize.getLottoPrizesInReverseOrderWithoutBlank()) {
			System.out.println(winningLottoCalculator.createWinningLottoMessage(lottoPrize));
		}
	}

	public void printRateOfReturn(WinningLottoCalculator winningLottoCalculator, PurchaseAmount purchaseAmount) {
		System.out.println("총 수익률은 " + winningLottoCalculator.getRateOfReturn(purchaseAmount) + "%입니다.");
	}

	public void printBlank() {
		System.out.println();
	}
}
