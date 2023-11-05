package lotto.controller;

import java.util.List;

import lotto.domain.AnswerLotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.service.MoneyService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	private MoneyService moneyService;
	private LottoService lottoService;
	private final InputView inputView;
	private final OutputView outputView;

	public LottoController() {
		this.moneyService = new MoneyService();
		this.lottoService = new LottoService();
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void play() {
		Money money = createMoney();
		Lottos lottos = createLottos(money);
		AnswerLotto answerLotto = createAnswerLotto();
		int priceSum = lottoService.calculateLottoPriceSum(lottos, answerLotto);
		double totalReturn = lottoService.calculateTotalReturn(money.money(), priceSum);

		printLottoResult(lottos, answerLotto, totalReturn);
	}

	public Money createMoney() {
		outputView.printInputMoneyMessage();

		Money money = createMoneyProgress();

		return money;
	}

	private Money createMoneyProgress() {
		while (true) {
			try {
				int inputValue = inputView.inputMoney();
				Money money = moneyService.createMoney(inputValue);
				return money;
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e);
			}
		}
	}

	public Lottos createLottos(Money money) {
		outputView.printBuyedLottoNumberMessage(money.getBuyedCount());

		Lottos lottos = lottoService.createLottos(money);

		outputView.printLottoNumbers(lottos.getFormattedLottoNumbers());

		return lottos;
	}

	public AnswerLotto createAnswerLotto() {
		outputView.printInputAnswerLottoNumberMessage();

		List<Integer> numbers = createAnswerLottoNumbersProgress();

		outputView.printInputBonusNumberMessage();

		int bonusNumber = createBonusNumberProgress(numbers);

		return lottoService.createAnswerLotto(numbers, bonusNumber);
	}

	private List<Integer> createAnswerLottoNumbersProgress() {
		while (true) {
			try {
				List<Integer> numbers = inputView.inputAnswerLottoNumbers();
				return numbers;
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e);
			}
		}
	}

	private int createBonusNumberProgress(List<Integer> numbers) {
		while (true) {
			try {
				int bonusNumber = inputView.inputBonusNumber(numbers);
				return bonusNumber;
			} catch (IllegalArgumentException e) {
				outputView.printErrorMessage(e);
			}
		}
	}

	public void printLottoResult(Lottos lottos, AnswerLotto answerLotto, double totalReturn) {
		outputView.printWinningStatisticsTopMessage();

		String message = lottoService.getWinningStatisticsMessage(lottos, answerLotto);

		outputView.printWinningStatisticsMessage(message);
		outputView.printTotalReturn(totalReturn);
	}
}
