package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
	Error error = new Error();

	public int getMoney() {
		Message.PURCHASE_MESSAGE.printMessage();
		String purchaseMoney = Console.readLine().trim();
		while (!error.validateMoney(purchaseMoney)){
			Message.PURCHASE_MESSAGE.printMessage();
			purchaseMoney = Console.readLine().trim();
		}
		return Integer.parseInt(purchaseMoney);
	}
	public int getLottoCount(int money) {
		return money / Number.LOTTO_PRICE.getNumber();
	}

	public List<Integer> getWinningNumbers() {
		List<Integer> winningNumbers = new ArrayList<>();
		String winningNumber = Console.readLine().trim();
		while (!error.validateWinningNumbers(winningNumber)){
			Message.WINNING_NUMBER_MESSAGE.printMessage();
			winningNumber = Console.readLine().trim();
		}
		for (String number : winningNumber.split(Message.SEPARATOR.getMessage())) {
			winningNumbers.add(Integer.parseInt(number));
		}
		return winningNumbers;
	}

	public int getBonusNumber(List<Integer> winningNumbers) {
		String bonusNumber = Console.readLine().trim();
		while (!error.validateBonusNumber(winningNumbers, bonusNumber)){
			Message.BONUS_NUMBER_MESSAGE.printMessage();
			bonusNumber = Console.readLine().trim();
		}
		return Integer.parseInt(bonusNumber);
	}
	public void compareLotto(List<Lotto> lottos, List<Integer> winningNumbers) {
		for (Lotto lotto : lottos) {
			int result = lotto.match(winningNumbers);
			boolean bonus = lotto.matchBonus(winningNumbers.size() - 1);
			Result.setResult(result, bonus);
		}
	}
}
