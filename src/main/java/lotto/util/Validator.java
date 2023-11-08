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
        if (money % Constant.MONEY_UNIT != 0 || money == 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }


    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < Constant.NUMBER_MIN || num > Constant.NUMBER_MAX)) {
            throw new IllegalArgumentException("[ERROR] 번호는 1이상 45이하 숫자여야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constant.NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Constant.NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
    }

    private void validateDuplicateBonusNumber(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복 됩니다.");
        }
    }

    private void validateRangeBonusNumber(int number) {
        if (number < Constant.NUMBER_MIN || number > Constant.NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 번호는 1이상 45이하 숫자여야 합니다.");
        }
    }


}
