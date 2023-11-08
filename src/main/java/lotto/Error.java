package lotto;
import java.util.ArrayList;
import java.util.List;

public class Error {
	Judgement judgement = new Judgement();

	public boolean validateMoney(String money){
		try {
			checkMoney(money);
		} catch (IllegalStateException | IllegalArgumentException e) {
			Message.ERROR_MESSAGE.printMessageWithString(e.getMessage());
			return false;
		}
		return true;
	}
	public boolean validateWinningNumbers(String digit){
		try {
			List<Integer> winningNumbersTemp = new ArrayList<>();
			for (String winningNumber : digit.split(Message.SEPARATOR.getMessage())) {
				checkWinningLotto(winningNumbersTemp, winningNumber);
				winningNumbersTemp.add(Integer.parseInt(winningNumber));
			}
		} catch (IllegalStateException | IllegalArgumentException e) {
			Message.ERROR_MESSAGE.printMessageWithString(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean validateBonusNumber(List<Integer> winningNumbers, String bonusNumber){
		try {
			checkWinningLotto(winningNumbers, bonusNumber);
		} catch (IllegalStateException | IllegalArgumentException e) {
			Message.ERROR_MESSAGE.printMessageWithString(e.getMessage());
			return false;
		}
		return true;
	}
	private void checkCommons(String digit) {
		if (judgement.isEmpty(digit))
			throw new IllegalStateException(Message.EMPTY.getMessage());
		if (!judgement.isStringDigit(digit))
			throw new IllegalArgumentException(Message.DIGIT.getMessage());
		if (judgement.isNegative(Integer.parseInt(digit)))
			throw new IllegalArgumentException(Message.NEGATIVE.getMessage());
	}
	public void checkMoney(String purchaseMoney) {
		checkCommons(purchaseMoney);
		if (!judgement.isRemainder(Integer.parseInt(purchaseMoney)))
			throw new IllegalArgumentException(Message.REMAINDER.getMessage());
	}

	public void checkWinningLotto(List<Integer> winningNumbers, String digit) {
		checkCommons(digit);
		if (!judgement.isInRange(Integer.parseInt(digit)))
			throw new IllegalArgumentException(Message.RANGE.getMessage());
		if (judgement.isDuplicate(winningNumbers, Integer.parseInt(digit)))
			throw new IllegalArgumentException(Message.DUPLICATE.getMessage());
	}
}
