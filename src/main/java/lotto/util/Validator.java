package lotto.util;

import static lotto.constant.Delimiter.COMMA;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_NOT_NUPLICATED_WINNUMBER;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_ONLY_NUMBER;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_RIGHT_RANGE;
import static lotto.constant.ErrorMessage.MONEY_NO_NEGATIVE;
import static lotto.constant.ErrorMessage.MONEY_ONLY_NUMBER;
import static lotto.constant.ErrorMessage.MONEY_UNIT_NUMBER;
import static lotto.constant.ErrorMessage.WINNUMBER_COMMA_DELIMITER;
import static lotto.constant.ErrorMessage.WINNUMBER_ONLY_NUMBER;
import static lotto.constant.NumberConstant.LAST_LOTTO_NUMBER;
import static lotto.constant.NumberConstant.MONEY_UNIT;
import static lotto.constant.NumberConstant.START_LOTTO_NUMBER;
import static lotto.constant.NumberConstant.ZERO;

import java.util.List;
import lotto.constant.Delimiter;
import lotto.service.Lotto;

public class Validator {

    public void validateInputMoneyIsNumber(String inputMoney) {
        try {
            Long.parseLong(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_ONLY_NUMBER.getMessage());
        }
    }

    public void validateNumberUnitIsThousand(Long money) {
        if (money % MONEY_UNIT.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException(MONEY_UNIT_NUMBER.getMessage());
        }
    }

    public void validateNumberNegativeOrZero(Long money) {
        if (money <= ZERO.getNumber()) {
            throw new IllegalArgumentException(MONEY_NO_NEGATIVE.getMessage());
        }
    }


    public void validateRightCommaCount(String inputWinnerNumbers,
        List<String> splitedInputWinnerNumbers) {
        long count = inputWinnerNumbers.chars().filter(number -> number == COMMA.getDelimiter().charAt(0)).count();
        if (count != splitedInputWinnerNumbers.size() - 1) {
            throw new IllegalArgumentException(WINNUMBER_COMMA_DELIMITER.getMessage());
        }
    }

    public void validateWinnumberOnlyNumber(List<String> inputWinnerNumbers) {
        try {
            List<Integer> collect = inputWinnerNumbers.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNUMBER_ONLY_NUMBER.getMessage());
        }
    }



    public void validateConvertedWinnerNumber(List<Integer> winnerNumbers) {
        try {
            Lotto lotto = new Lotto(winnerNumbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void validateBonusNumberInput(String bonusNumberInput) {
        try {
            Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_ONLY_NUMBER.getMessage());
        }
    }

    public void validateBonusNumberRange(int convertedBonusNumber) {
        if (isNumberNotInRange(convertedBonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_RIGHT_RANGE.getMessage());
        }
    }

    public void validateIsBonusNumberInWinnerNumber(List<Integer> lottoWinNumbers,
        int bonusNumberInput) {
        if (lottoWinNumbers.contains(bonusNumberInput)) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_NUPLICATED_WINNUMBER.getMessage());
        }
    }

    private boolean isNumberNotInRange(Integer winnerNumber) {
        return winnerNumber < START_LOTTO_NUMBER.getNumber()
            || winnerNumber > LAST_LOTTO_NUMBER.getNumber();
    }

}
