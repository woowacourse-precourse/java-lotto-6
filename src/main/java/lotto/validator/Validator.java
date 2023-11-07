package lotto.validator;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.NumberRange;
import lotto.util.IntUtil;

public class Validator {
    public static void validateMoney(String money) {
        isNumber(money);
        isOverThousand(Integer.parseInt(money));
        divideByThousand(Integer.parseInt(money));
    }

    public static void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.NOT_INT_ERROR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void isOverThousand(int money) {
        if (money < 1000) {
            System.out.println(ErrorMessage.NOT_ENOUGH_MONEY_ERROR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void divideByThousand(int money) {
        if (money % 1000 != 0) {
            System.out.println(ErrorMessage.MONEY_ERROR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void validateLotto(String lotto) {
        List<Integer> lottoNumbers = IntUtil.makeIntegerNumbers(lotto);
        haveDuplicate(lottoNumbers);
        isSixNumber(lottoNumbers);
        for (int number : lottoNumbers) {
            isInRange(number);
        }
    }

    public static void haveDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() < numbers.size()) {
            System.out.println(ErrorMessage.DUPLICATE_ERROR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void isSixNumber(List<Integer> lottoNumber) {
        if (lottoNumber.size() != 6) {
            System.out.println(ErrorMessage.NOT_SIX_NUMBER_ERROR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void isInRange(int number) {
        if (!(number >= NumberRange.LOWEST_NUMBER.getRangeNumber()
                && number <= NumberRange.HIGHEST_NUMBER.getRangeNumber())) {
            System.out.println(ErrorMessage.RANGE_ERROR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        isNumber(bonusNumber);
        int bonus = Integer.parseInt(bonusNumber);
        isInRange(bonus);
        isNotDuplicate(bonus, winningNumbers);
    }

    public static void isNotDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        for (Integer lottoNumber : winningNumbers) {
            if (bonusNumber == lottoNumber) {
                System.out.println(ErrorMessage.DUPLICATE_ERROR_MESSAGE.getErrorMessage());
                throw new IllegalArgumentException();
            }
        }
    }
}
