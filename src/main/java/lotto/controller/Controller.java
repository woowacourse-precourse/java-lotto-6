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
		OutputView.askPurchaseAmount();

		String money = InputView.getUserInput();

		PurchaseAmount purchaseAmount = new PurchaseAmount(money);

		lottoPlayer = lottoMachine.purchaseLotto(purchaseAmount);

		OutputView.printPlayerLottos(lottoPlayer);
	}

	private void createWinningLotto() {
		OutputView.askWinningNumbers();

		String numbers = InputView.getUserInput();

		WinningNumbers winningNumbers = new WinningNumbers(numbers);

		OutputView.askBonusNumber();

		String number = InputView.getUserInput();

		BonusNumber bonusNumber = new BonusNumber(number);

		winningLotto = new WinningLotto(winningNumbers, bonusNumber);
	}

	private void printResult() {
		LottoResult lottoResult = new LottoResult(winningLotto, lottoPlayer);

		OutputView.printWinningStatistics(lottoResult);
	}
}