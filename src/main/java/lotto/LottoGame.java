package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	private String purchaseMoney;
	private final Error error = new Error();
	List<Lotto> lottos;
	ArrayList<Integer> winningNumbers;
	public void moneyInit() {
		int purchaseMoney;
		Message.PURCHASE_MESSAGE.getMessage();
		this.purchaseMoney = Console.readLine().trim();
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
		Message.PURCHASE_COUNT_MESSAGE.getMessage(lottoCount);
		for (int i = Number.ZERO.getNumber(); i < lottoCount; i++){
			lottos.add(new Lotto(generator.numberGenerator()));
		}
	}

	public void winningNumberInit(){
		Message.WINNING_NUMBER_MESSAGE.getMessage();
		String winningNumber = Console.readLine().trim();
		for (String digit : winningNumber.split(",")) {
			winningNumbers.add(checkValidate(digit));
		}
	}

	public void bonusNumberInit(){
		Message.BONUS_NUMBER_MESSAGE.getMessage();
		String bonusNumber = Console.readLine().trim();
		winningNumbers.add(checkValidate(bonusNumber));
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

	public void compareLotto(){

		for (Lotto lotto : lottos) {
			int result = lotto.match(winningNumbers);
			boolean bonus = lotto.matchBonus(winningNumbers.size() - 1);
			Result.setResult(result, bonus);
		}
		Result.printResult();
	}
	public int getLottoCount() {
		return Integer.parseInt(purchaseMoney) / 1000;
	}
}
