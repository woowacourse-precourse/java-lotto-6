package lotto;

import java.util.List;

import lotto.View.InputView;
import lotto.View.OutputView;

public class Game {
	private User user;
	private WinningInfo winningInfo;
	private LottoGenerator lottoGenerator;
	Game(User user, WinningInfo winningInfo, LottoGenerator lottoGenerator){
		this.user = user;
		this.winningInfo = winningInfo;
		this.lottoGenerator = lottoGenerator;
	}
	public void run(){
		Money pay = getPay();
		int lottoCount = pay.calculateLottoCount();
		System.out.println(lottoCount);
		//List<Lotto> lottos = lottoGenerator.makeLotto(lottoCount);
		//user.setLottos(lottos);

		//OutputView.printPurchasedMessage(lottoCount, lottos);

		winningInfo.setWinningNumbers();
		winningInfo.setBonusNumber();

		//List<Integer> prices = calculatePrices(user, winningInfo){};

		//OutputView.printResult(prices);
	}

	private Money getPay() {
		while(true){
			try{
				String input = InputView.getPayInput();
				return new Money(input);
			}catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}


	//private List<Integer> calculatePrices(User user, WinningInfo winningInfo){}


}
