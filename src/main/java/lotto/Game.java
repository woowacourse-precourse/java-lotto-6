package lotto;

import java.util.List;

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
		int pay = getPay();
		int lottoCount = calculateLottoCount(pay);
		List<Lotto> lottos = lottoGenerator.makeLotto(lottoCount);
		user.setLottos(lottos);

		OutputView.printPurchasedMessage(lottoCount, lottos);

		winningInfo.setWinningNumbers();
		winningInfo.setBonusNumber();

		List<Integer> prices = calculatePrices(user, winningInfo){}

		OutputView.printResult(prices);
	}

	private int getPay(){
		return 0;
	};

	private int calculateLottoCount(int pay){
		return 0;
	}

	private List<Integer> calculatePrices(User user, WinningInfo winningInfo){}


}
