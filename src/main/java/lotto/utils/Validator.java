package lotto.utils;


import java.util.HashSet;
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

    public static void validateWinningNumber(String numbers) {
        String[] numberStrings = numbers.replace("", " ").split(",");
        validateNumberCount(numberStrings);

        Set<Integer> numberSet = new HashSet<>();
        for (String numberString : numberStrings) {
            int number = validateNumberRange(numberString);
            validateDuplicateNumber(number, numberSet);
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        validateNumberRange(bonusNumber);
    }

    private static void validateNumberCount(String[] numberStrings) {
        if (numberStrings.length != LottoNumber.COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 숫자 6개를 입력하여 주세요.");
        }
    }

    private static void validateDuplicateNumber(int number, Set<Integer> numberSet) {
        if (!numberSet.add(number)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 중복되지 않은 수여야 합니다.");
        }
    }

    private static int validateNumberRange(String numberString) {
        int number = Integer.parseInt(numberString);

        if (number < LottoNumber.MIN.getValue() || number > LottoNumber.MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 수여야 합니다.");
        }
        return number;
    }
}
