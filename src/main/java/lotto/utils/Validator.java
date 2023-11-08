package lotto.utils;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.LottoNumber;

public class Validator {

    private static final int VALIDATE_MONEY_NUMBER = 1000;

    public static void validateMoney(String money) {
        if (!isNumeric(money)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }

        if (!isThousandUnit(money)) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
    }

    private static boolean isNumeric(String money) {
        try {
            int number = Integer.parseInt(money);
            return money.equals(Integer.toString(number));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isThousandUnit(String money) {
        int number = Integer.parseInt(money);
        return number % VALIDATE_MONEY_NUMBER == 0;
    }

    public static void validateWinningNumber(List<Integer> numbers) {
        validateNumberCount(numbers);

        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            validateNumberRange(number);
            validateDuplicateNumber(number, numberSet);
        }
    }

    public static void validateBonusNumber(List<Integer> winNumber, String number) {
        int bonusNumber = Integer.parseInt(number);
        validateNumberRange(bonusNumber);
        validateDuplicateBonusNumber(winNumber, bonusNumber);
    }

    private static void validateDuplicateBonusNumber(List<Integer> winningNumber, int BonusNumber) {
        if (winningNumber.contains(BonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
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
