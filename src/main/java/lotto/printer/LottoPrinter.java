package lotto.printer;

import java.util.List;

import lotto.lotto.Lotto;

public interface LottoPrinter {
	void askInputPurchasePrice();

	void noticePurchaseLotto(List<Lotto> purchasedLottos);

	void askWinningNumber();

	void askBonusNumber();

	void noticeResult(int[] results, Double returnRate);
}
