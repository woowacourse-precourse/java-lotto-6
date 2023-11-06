package lotto.controller;

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
		try {
			OutputView.askPurchaseAmount();

			String money = InputView.getUserInput();

			PurchaseAmount purchaseAmount = new PurchaseAmount(money);

			lottoPlayer = lottoMachine.purchaseLotto(purchaseAmount);

			OutputView.printPlayerLottos(lottoPlayer);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			purchaseLotto();
		}
	}

	private void createWinningLotto() {
		try {
			WinningNumbers winningNumbers = createWinningNumbers();
			BonusNumber bonusNumber = createBonusNumber();

			winningLotto = new WinningLotto(winningNumbers, bonusNumber);
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			createWinningLotto();
		}
	}

	private BonusNumber createBonusNumber() {
		try {
			OutputView.askBonusNumber();
			String number = InputView.getUserInput();

			return new BonusNumber(number);
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return createBonusNumber();
		}
	}

	private WinningNumbers createWinningNumbers() {
		try {
			OutputView.askWinningNumbers();

			String numbers = InputView.getUserInput();

			return new WinningNumbers(numbers);
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			return createWinningNumbers();
		}
	}

	private void printResult() {
		LottoResult lottoResult = new LottoResult(winningLotto, lottoPlayer);

		OutputView.printWinningStatistics(lottoResult);
	}
}