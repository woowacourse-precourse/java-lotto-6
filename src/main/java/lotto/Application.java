package lotto;

import java.util.List;

import lotto.io.Input;
import lotto.io.Output;

public class Application {
	private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String BUY_QUANTITY_MESSAGE = "%d개를 구매했습니다.\n";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

	public static void main(String[] args) {
		System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
		final var amount = Input.readPurchaseAmount();
		final var lottoSeller = new LottoSeller();
		final var lottos = lottoSeller.sellLotto(amount);
		System.out.printf(BUY_QUANTITY_MESSAGE, lottos.size());
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}

		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		final var winningNumbers = Input.readWinningNumbers();

		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		final var bonusNumber = Input.readBonusNumbers();

		final LottoResult lottoResult = WinningResult.calculateResult(lottos, winningNumbers, bonusNumber);
		List<Integer> winningResult = lottoResult.getWinningResult();

		Output.printFunction(winningResult, lottoResult.getTotalPrize(), amount);
	}
}
