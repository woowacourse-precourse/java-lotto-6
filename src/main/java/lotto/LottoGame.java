package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private String purchaseMoney;
	private final Error error = new Error();
	List<Lotto> lottos;
	ArrayList<Integer> winningNumbers;
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

	public void WinningNumberInit(){
		Input input = new Input();
		Output.WINNING_NUMBER_MESSAGE.getMessage();
		String winningNumber = input.getUserInput().trim();
		for (String digit : winningNumber.split(",")) {
			winningNumbers.add(checkValidate(digit));
		}
	}

	private int checkValidate(String digit){
		int number;
		if (!error.isStringDigit(digit))
			throw new IllegalArgumentException();
		number = Integer.parseInt(digit);
		if (!error.isInRange(number))
			throw new IllegalArgumentException();
		if (error.isNegative(number))
			throw new IllegalArgumentException();
		if (error.isDuplicate(winningNumbers, number))
			throw new IllegalArgumentException();
		return number;
	}
	public int getLottoCount() {
		return Integer.parseInt(purchaseMoney) / 1000;
	}
}
