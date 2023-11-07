package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_SIZE = 6;
    public static final String INVALID_NUMBERS = "[ERROR] 유효하지 않은 숫자입니다.";
    public static final String INVALID_NUMBER = "[ERROR] 숫자를 입력해 주세요";
    public static final String INVALID_SIZE_MESSAGE = "[ERROR] 로또 개수는 6개여야 합니다";
    public static final String OUT_OF_RANGE_MESSAGE = "[ERROR] 숫자 범위는 1~45여야 합니다";
    public static final String DUPLICATE_NUMBER_MESSAGE = "[ERROR] 숫자에 중복이 있으면 안 됩니다";
    public static final String INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며, 당첨 번호와 중복될 수 없습니다.";
    public static final String ERROR_INVALID_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";

    private Validator() {
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX
            || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
        }
    }

    public static void validatePurchaseAmount(String input) {
        int amount = 0;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
        if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_PURCHASE_AMOUNT);
        }
    }

    public static void validate(List<Integer> numbers) {
        isSizeValid(numbers);
        validateRange(numbers);
        validateUniqueness(numbers);
    }

    private static void isSizeValid(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private static void validateRange(List<Integer> list) {
        for (int number : list) {
            if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
            }
        }
    }

    private static void validateUniqueness(List<Integer> list) {
        Set<Integer> numberSet = new HashSet<>(list);
        if (numberSet.size() != list.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }


}
