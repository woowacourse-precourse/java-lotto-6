package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningStatistics;
import lotto.view.Input;
import lotto.view.Output;

public class GameController {
	
	Input input = new Input();
	Output output = new Output();
	PurchaseLottos purchaseLottos = new PurchaseLottos();
	
	public void start() {
		Lottos purchasedLottos = new Lottos();
		int money = purchase(purchasedLottos);
		
		Lotto winningLotto = enterWinningLotto();
		BonusNumber bonusNumber = enterBonusNumber(winningLotto);
		
		printWinningStatistics(purchasedLottos, winningLotto, bonusNumber, money);
	}
	
	private int purchase(Lottos lottos) {
		int money = enterMoney();
		purchaseLottos.generated(lottos, money);
		return money;
	}

	private int enterMoney() {
		try {
			return input.numberOfPurchasedLotto();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return enterMoney();
		}
	}
	
	private Lotto enterWinningLotto() {
		try {
			return new Lotto(input.winningNumber());
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return enterWinningLotto();
		}
	}

	private BonusNumber enterBonusNumber(Lotto winningLotto) {
		try {
			return new BonusNumber(input.bonusNumber(), winningLotto);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return enterBonusNumber(winningLotto);
		}
	}
	
	private void printWinningStatistics(Lottos purchasedLottos, Lotto winningLotto, BonusNumber bonusNumber, int money) {
		WinningStatistics winningStatistics = new WinningStatistics();
		
		for(Lotto purchasedLotto : purchasedLottos.getLottos()) {
			winningStatistics.addWinning(purchasedLotto, winningLotto, bonusNumber);
		}
		
		output.statistics(winningStatistics.getWinnings(), winningStatistics.getTotalProfitRate(money));
	}
}
