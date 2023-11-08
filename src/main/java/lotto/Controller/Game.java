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
	public void run() {
		Money pay = makeMoneyWithInput();
		User user = buyLottoTickets(pay);
		WinningInfo winningInfo = determineWinningInfo();
		givePrizes(winningInfo, user);
	}

	private User buyLottoTickets(Money pay) {
		int lottoCount = pay.calculateAffordableLottoCount();
		List<Lotto> lottos = lottoGenerator.makeLotto(lottoCount);
		OutputView.printPurchasedMessage(lottoCount, lottos);
		return new User(pay, lottos);
	}

	private WinningInfo determineWinningInfo() {
		WinningNumbers winningNumbers = makeWinningNumbersWithInput();
		BonusNumber bonusNumber = makeBonusNumberWithInput(winningNumbers);
		return new WinningInfo(winningNumbers, bonusNumber);
	}

	private void givePrizes(WinningInfo winningInfo, User user){
		Map<Prize, Integer> prizes = winningCalculator.calculatePrizes(winningInfo, user.getLottos());
		double profitRate = winningCalculator.calculateProfitRate(prizes, user.getMoney());
		OutputView.printResult(prizes, profitRate);
	}

	private Money makeMoneyWithInput() {
		while(true){
			try{
				String payInput = InputView.getPayInput();
				return new Money(payInput);
			}catch(IllegalArgumentException e){
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
