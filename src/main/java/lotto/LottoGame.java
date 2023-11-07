package lotto;

public class LottoGame {
	private String purchaseMoney;
	private Error error = new Error();
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
	public int getLottoCount() {
		return Integer.parseInt(purchaseMoney) / 1000;
	}
}
