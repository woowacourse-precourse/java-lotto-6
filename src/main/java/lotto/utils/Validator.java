package lotto.utils;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.LottoNumber;

public class Validator {

    private static final int VALIDATE_MONEY_NUMBER = 1000;

    public static void validateMoney(String money) {
        int purchaseMoney = Integer.parseInt(money);
        if (purchaseMoney%VALIDATE_MONEY_NUMBER != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
    }

    public static void validateWinningNumber(List<Integer> numbers) {
        validateNumberCount(numbers);

        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            validateNumberRange(number);
            validateDuplicateNumber(number, numberSet);
        }
    }

    public static void validateBonusNumber(String number) {
        int bonusNumber = Integer.parseInt(number);
        validateNumberRange(bonusNumber);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력하여 주세요.");
        }
    }

    private static void validateDuplicateNumber(int number, Set<Integer> numberSet) {
        if (!numberSet.add(number)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복되지 않은 수여야 합니다.");
        }
    }

    private static void validateNumberRange(int number) {
        if (number < LottoNumber.MIN.getValue() || number > LottoNumber.MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 수여야 합니다.");
        }
    }
}
