package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class PurchaseLottos {
	
	private final int MONEY_UNIT = 1000;

	public void generated(Lottos lottos, int money) {
		GenerateLotto generateLotto = new GenerateLotto();

		int numberOfPurchases = numberPurchases(money);
		for (int i = 0; i < numberOfPurchases; i++) {
			Lotto lotto = new Lotto(generateLotto.numbers());
			lottos.addLotto(lotto);
		}
	}

	private int numberPurchases(int money) {
		return money / MONEY_UNIT;
	}
}
