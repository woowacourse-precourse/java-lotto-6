package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {
    private static final int DIVIDED_AMOUNT = 1000;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final String INVALID_AMOUNT_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    private static final String INVALID_RANGE_MESSAGE = "[ERROR] 1~45 사이의 숫자를 입력해야 합니다.";
    private static final String INVALID_NUMBER_MESSAGE = "[ERROR] 숫자이여야 합니다.";
    private static final String INVALID_DUPLICATE_MESSAGE = "[ERROR] 중복된 숫자가 없어야 합니다.";
    private static final String INVALID_DUPLICATE_LOTTO_BONUS = "[ERROR] 보너스 번호가 당첨 번호에 중복됩니다.";

    public static void validateNumber(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount % DIVIDED_AMOUNT != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_MESSAGE);
        }
    }

    public static void validateNumberInRange(int number) {
        if (number < START_RANGE || number > END_RANGE) {
            throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
        }
    }

    public static void validateDuplicateNumbers(String[] parts) {
        Set<String> uniqueNumbers = new HashSet<>();
        for (String part : parts) {
            if (!uniqueNumbers.add(part)) {
                throw new IllegalArgumentException(INVALID_DUPLICATE_MESSAGE);
            }
        }
    }

    public static void validateDuplicateNumbers(Lotto lotto, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_LOTTO_BONUS);
        }
    }
}
