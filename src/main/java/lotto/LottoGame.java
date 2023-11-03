package lotto;

import java.util.List;

import lotto.domain.AnswerLotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.service.MoneyService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

	private MoneyService moneyService;
	private LottoService lottoService;
	private final InputView inputView;
	private final OutputView outputView;

	public LottoGame() {
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
		double totalReturn = lottoService.calculateTotalReturn(money.getMoney(), priceSum);

		printLottoResult(lottos, answerLotto, totalReturn);
	}

	public Money createMoney() {
		outputView.printInputMoneyMessage();
		int money = inputView.inputMoney();
		return moneyService.createMoney(money);
	}

	public Lottos createLottos(Money money) {
		outputView.printBuyedLottoNumberMessage(money.getBuyedCount());

		lottoService.setMoney(money);
		Lottos lottos = lottoService.createLottos();

		outputView.printLottoNumbers(lottos.printLottoNumbers());

		return lottos;
	}

	public AnswerLotto createAnswerLotto() {
		outputView.printInputAnswerLottoNumberMessage();
		List<Integer> numbers = inputView.inputAnswerLottoNumbers();

		outputView.printInputBonusNumberMessage();
		int bonusNumber = inputView.inputBonusNumber();

		return lottoService.createAnswerLotto(numbers, bonusNumber);
	}

	public void printLottoResult(Lottos lottos, AnswerLotto answerLotto, double totalReturn) {
		outputView.printWinningStatisticsTopMessage();
		String message = lottoService.getWinningStatisticsMessage(lottos, answerLotto);
		outputView.printWinningStatisticsMessage(message);
		outputView.printTotalReturn(totalReturn);
	}
}
