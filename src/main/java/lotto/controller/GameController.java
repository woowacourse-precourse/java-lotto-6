package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
	
	InputView input = new InputView();
	OutputView output = new OutputView();
	PurchaseLottos generatePurchaseLottos = new PurchaseLottos();
	Lottos purchasedLottos = new Lottos();
	
	public void start() {
		int money = purchase();
		output.lottos(purchasedLottos);
		
		Lotto winningLotto = getWinningLotto();
		
		WinningStatistics winningStatistics = getWinningStatistics(winningLotto, getBonusNumber(winningLotto));
		output.statistics(winningStatistics.getWinnings(), winningStatistics.getTotalProfitRate(money));
	}
	
	private int purchase() {
		int money = getMoney();
		generatePurchaseLottos.generated(purchasedLottos, money);
		return money;
	}

	private int getMoney() {
		try {
			return input.numberOfPurchasedLotto();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getMoney();
		}
	}
	
	private Lotto getWinningLotto() {
		try {
			return new Lotto(input.winningNumber());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getWinningLotto();
		}
	}

	private BonusNumber getBonusNumber(Lotto winningLotto) {
		try {
			return new BonusNumber(input.bonusNumber(), winningLotto);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return getBonusNumber(winningLotto);
		}
	}
	
	private WinningStatistics getWinningStatistics(Lotto winningLotto, BonusNumber bonusNumber) {
		WinningStatistics winningStatistics = new WinningStatistics();
		
		for(Lotto purchasedLotto : purchasedLottos.getLottos()) {
			winningStatistics.addWinning(purchasedLotto, winningLotto, bonusNumber);
		}
		return winningStatistics;
	}
}