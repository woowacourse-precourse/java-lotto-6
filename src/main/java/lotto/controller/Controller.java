package lotto.controller;

import java.util.function.Function;
import lotto.domain.BonusNumber;
import lotto.domain.LottoMachine;
import lotto.domain.LottoPlayer;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

	private final LottoMachine lottoMachine = new LottoMachine();
	private LottoPlayer lottoPlayer;
	private WinningLotto winningLotto;

	public void run() {
		purchaseLotto();

		createWinningLotto();

		printResult();
	}

	private void purchaseLotto() {
		OutputView.askPurchaseAmount();

		String money = getValidInput(PurchaseAmount::new);

		PurchaseAmount purchaseAmount = new PurchaseAmount(money);

		lottoPlayer = lottoMachine.purchaseLotto(purchaseAmount);

		OutputView.printPlayerLottos(lottoPlayer);
	}

	private void createWinningLotto() {
		WinningNumbers winningNumbers = createWinningNumbers();
		BonusNumber bonusNumber = createBonusNumber();

		winningLotto = new WinningLotto(winningNumbers, bonusNumber);
	}

	private BonusNumber createBonusNumber() {
		OutputView.askBonusNumber();

		String number = getValidInput(BonusNumber::new);

		return new BonusNumber(number);
	}

	private WinningNumbers createWinningNumbers() {
		OutputView.askWinningNumbers();

		String numbers = getValidInput(WinningNumbers::new);

		return new WinningNumbers(numbers);
	}

	private void printResult() {
		LottoResult lottoResult = new LottoResult(winningLotto, lottoPlayer);

		OutputView.printWinningStatistics(lottoResult);
	}

	private <T> String getValidInput(Function<String, T> constructor) {
		String input;
		do {
			input = InputView.getUserInput();
			try {
				constructor.apply(input);
			} catch (IllegalArgumentException e) {
				OutputView.printExceptionMessage(e.getMessage());
				input = null;
			}
		} while (input == null);

		return input;
	}
}