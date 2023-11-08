package lotto.util;

import java.util.List;
import lotto.constant.Constant;

public class Validator {

    private volatile static Validator INSTANCE;

    private Validator() {
    }

    public static Validator getInstance() {
        if (INSTANCE == null) {
            synchronized (Validator.class) {
                generateInstance();
            }
        }
        return INSTANCE;
    }

    private static void generateInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Validator();
        }
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }


    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateRangeBonusNumber(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber, winningNumbers);
    }

    public void validateMoney(int money) {
        validateNumberFormat(money);
        validateMoneyUnit(money);
    }

    private void validateMoneyUnit(int money) {
        if (money % Constant.MONEY_UNIT != 0 || money == 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_WRONG_UNIT);
        }
    }

    private void validateNumberFormat(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_WRONG_FORMAT);
        }
    }


    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < Constant.NUMBER_MIN || num > Constant.NUMBER_MAX)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_WRONG_RANGE);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constant.NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_WRONG_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Constant.NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_DUPLICATE);
        }
    }

    private void validateDuplicateBonusNumber(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_AND_WINNING_DUPLICATE);
        }
    }

    private void validateRangeBonusNumber(int number) {
        if (number < Constant.NUMBER_MIN || number > Constant.NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_WRONG_RANGE);
        }
    }


}
