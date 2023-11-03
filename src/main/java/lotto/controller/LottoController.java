package lotto.controller;

import java.util.List;

import lotto.domain.AnswerLotto;
import lotto.domain.LotteryStatistician;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.generator.LottosGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	private final InputView inputView;
	private final OutputView outputView;
	private final LottosGenerator lottosGenerator;

	public LottoController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		this.lottosGenerator = new LottosGenerator();
	}

	public void play() {
		Money money = createMoney();
		Lottos lottos = createLottos(money);
		AnswerLotto answerLotto = createAnswerLotto();
		
		getResult(money, lottos, answerLotto);
	}

	private Money createMoney() {
		outputView.printInputMoneyMessage();
		Money money = new Money(inputView.inputMoney());
		return money;
	}

	private Lottos createLottos(Money money) {
		lottosGenerator.setMoney(money);
		
		Lottos lottos =  new Lottos(lottosGenerator.generate());
		
		printLottosNumbers(money, lottos);
		
		return lottos;
	}

	private void printLottosNumbers(Money money, Lottos lottos) {
		outputView.printBuyedLottoNumberMessage(money.getBuyedCount());
		outputView.printLottoNumbers(lottos.printLottoNumbers());
	}

	private AnswerLotto createAnswerLotto() {
		outputView.printInputAnswerLottoNumberMessage();
		List<Integer> numbers = inputView.inputAnswerLottoNumbers();
		
		outputView.printInputBonusNumberMessage();
		int bonusNumber = inputView.inputBonusNumber();
		
		return new AnswerLotto(numbers, bonusNumber);
	}
	
	public void getResult(Money money, Lottos lottos, AnswerLotto answerLotto) {
		LotteryStatistician test = new LotteryStatistician(money, lottos, answerLotto);
		
		outputView.printWinningStatisticsTopMessage();
		outputView.printWinningStatisticsMessage(test.getWinningStatisticsMessage());
		outputView.printTotalReturn(test.getTotalReturn());
	}
}
