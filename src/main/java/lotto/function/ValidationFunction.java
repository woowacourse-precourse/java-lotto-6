package lotto.function;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;
import lotto.domain.Lotto;

import java.util.stream.Stream;

public class ValidationFunction {

    public int validateMoney(int money) {
        if (money % LottoNumber.PURCHASE_CONDITION.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_WRONG);
        }
        return money;
    }

    public void validateMoneyIsNumber(String money) {
        String regex = "[0-9]+";
        if(!money.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_ONLY_NUMBER);
        }
    }

    public void validateWinningNumberSize(String[] winningNumbers) {
        if (winningNumbers.length != LottoNumber.LENGTH_CONDITION.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_SIZE);
        }
    }

    public void validateWinningNumberRange(String[] winningNumbers) {
        for (int i = 0; i < LottoNumber.LENGTH_CONDITION.getNumber(); i++) {
            int compareNum = Integer.parseInt(winningNumbers[i]);
            if (compareNum < LottoNumber.FIRST_RANGE.getNumber() || compareNum > LottoNumber.LAST_RANGE.getNumber()) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_RANGE);
            }
        }
    }

    public void validateWinningNumberDuplicate(String[] winningNumbers) {
        Long winningNumbersSize = Stream.of(winningNumbers).distinct().count();
        if (winningNumbersSize != winningNumbers.length) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_DUPLICATE);
        }
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoNumber.FIRST_RANGE.getNumber() || bonusNumber > LottoNumber.LAST_RANGE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE);
        }
    }

}
