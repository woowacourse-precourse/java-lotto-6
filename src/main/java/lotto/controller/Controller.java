package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoPlayer;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
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

		String winningNumbers = InputView.getUserInput();

		OutputView.askBonusNumber();

		String bonusNumber = InputView.getUserInput();

		winningLotto = new WinningLotto(winningNumbers, bonusNumber);
	}

	private void printResult() {
		LottoResult lottoResult = new LottoResult(winningLotto, lottoPlayer);

		OutputView.printWinningStatistics(lottoResult);
	}
}