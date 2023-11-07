package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static final String ERROR_LOTTO_SIZE = "[ERROR] 로또는 6개의 숫자로 이루어져야 합니다.";
    public static final String ERROR_NUMBER_RANGE = "[ERROR] 로또 숫자는 1부터 45 사이어야 합니다.";
    public static final String ERROR_DUPLICATE_NUMBERS = "[ERROR] 로또 숫자에 중복된 숫자가 있습니다.";
    public static final String ERROR_INVALID_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    public static final String ERROR_NOT_THOUSAND_UNIT = "[ERROR] 1000원 단위로 입력해주세요.";
    public static final String ERROR_INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호를 확인해주세요.";

    public void validateLottoNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Lotto.MIN_NUMBER || number > Lotto.MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
            }
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }

    public static void validateThousandUnit(int amount) {
        if (amount % 1 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_THOUSAND_UNIT);
        }
    }

    public static void validateInvalidNumber() {
        throw new IllegalArgumentException(ERROR_INVALID_NUMBER);
    }



    public static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < Lotto.MIN_NUMBER || bonusNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER);
        }
    }
}
