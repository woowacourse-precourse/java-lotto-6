package lotto;

import java.util.List;

public class LottoGame {
	private String purchaseMoney;
	private Error error = new Error();
	List<Lotto> lottos;
	public void moneyInit() {
		Input input = new Input();
		int purchaseMoney;
		Output.PURCHASE_MESSAGE.getMessage();
		this.purchaseMoney = input.getUserInput();
		if (!error.isStringDigit(this.purchaseMoney))
			throw new IllegalArgumentException();
		purchaseMoney = Integer.parseInt(this.purchaseMoney);
		if (error.isRemainder(purchaseMoney))
			throw new IllegalArgumentException();
		if (error.isNegative(purchaseMoney))
			throw new IllegalArgumentException();
	}

	public void lottoInit() {
		NumberGenerator generator = new NumberGenerator();
		int lottoCount = getLottoCount();
		Output.PURCHASE_COUNT_MESSAGE.getMessage(lottoCount);
		for (int i = 0; i < lottoCount; i++){
			lottos.add(new Lotto(generator.numberGenerator()));
		}
	}
	public int getLottoCount() {
		return Integer.parseInt(purchaseMoney) / 1000;
	}
}
