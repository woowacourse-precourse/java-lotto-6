//Game.java
package lotto.Controller;

import java.util.List;
import java.util.Map;

import lotto.BonusNumber;
import lotto.Enum.Prize;
import lotto.Lotto;
import lotto.Money;
import lotto.User;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.WinningInfo;
import lotto.WinningNumbers;

public class Game {
	private LottoGenerator lottoGenerator;
	private WinningCalculator winningCalculator;
	public Game(LottoGenerator lottoGenerator, WinningCalculator winningCalculator){
		this.lottoGenerator = lottoGenerator;
		this.winningCalculator = winningCalculator;
	}
	public void run(){
		Money pay = makeMoneyWithInput();
		int lottoCount = pay.calculateAffordableLottoCount();
		List<Lotto> lottos = lottoGenerator.makeLotto(lottoCount);

		User user = new User(pay, lottos);

		OutputView.printPurchasedMessage(lottoCount, lottos);

		WinningNumbers winningNumbers = makeWinningNumbersWithInput();
		BonusNumber bonusNumber = makeBonusNumberWithInput(winningNumbers);

		WinningInfo winningInfo = new WinningInfo(winningNumbers, bonusNumber);

		List<Lotto> userLotto = user.getLottos();
		Map<Prize, Integer> prizes = winningCalculator.calculatePrizes(winningInfo, userLotto);
		double profitRate = winningCalculator.calculateProfitRate(prizes, pay.getMoney());

		OutputView.printResult(prizes, profitRate);
	}

	private Money makeMoneyWithInput() {
		while(true){
			try{
				String payInput = InputView.getPayInput();
				return new Money(payInput);
			}catch(IllegalArgumentException e){
				System.out.println("I'm here");
				System.out.println(e.getMessage());
			}
		}
	}


	private WinningNumbers makeWinningNumbersWithInput(){
		while(true){
			try{
				String input = InputView.getWinningNumbersInput();
				return new WinningNumbers(input);
			}catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private BonusNumber makeBonusNumberWithInput(WinningNumbers winningNumbers){
		while(true){
			try{
				String input = InputView.getBonusNumberInput();
				return new BonusNumber(input, winningNumbers);
			}catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}
}
