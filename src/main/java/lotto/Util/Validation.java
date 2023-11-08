package lotto.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static final String INPUT_TYPE_ERROR_MSG
            = "[ERROR] 숫자를 입력해주세요.";
    private static final String INPUT_UNIT_ERROR_MSG
            = "[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요.";
    private static final String INPUT_RANGE_ERROR_MSG
            = "[ERROR] 당첨 번호는 1 이상 45 이하의 정수로 입력해주세요.";
    private static final String INPUT_WINNER_NUMBER_DUPLICATED_ERROR_MSG
            = "[ERROR] 당첨 번호 중 중복되는 번호가 있습니다.";
    private static final String INPUT_WINNER_NUMBER_SIZE_ERROR_MSG
            = "[ERROR] 총 6개의 당첨 번호를 입력해주세요.";
    private static final String INPUT_WINNER_BONUS_DUPLICATED_ERROR_MSG
            = "[ERROR] 당첨 번호 중 보너스 번호와 중복되는 번호가 존재합니다.";

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int SIZE = 6;
    private static final int UNIT = 1000;
    private static final int ZERO = 0;
    private static final String SEPERATOR = ",";

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR_MSG);
        }
    }

    private static void validateUnit(int purchaseAmount) {
        if (purchaseAmount % UNIT != ZERO) {
            throw new IllegalArgumentException(INPUT_UNIT_ERROR_MSG);
        }
    }

    private static void validateRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(INPUT_RANGE_ERROR_MSG);
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        Set<Integer> sample = new HashSet<>(numbers);

        if (sample.size() != numbers.size()) {
            throw new IllegalArgumentException(INPUT_WINNER_NUMBER_DUPLICATED_ERROR_MSG);
        }

        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(INPUT_WINNER_NUMBER_SIZE_ERROR_MSG);
        }
    }

    private static void validateDuplicatedBonusNumber(List<Integer> winnerNumbers, int bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_WINNER_BONUS_DUPLICATED_ERROR_MSG);
        }
    }

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount = parseInteger(input);
        validateUnit(purchaseAmount);
        return purchaseAmount;
    }

    public static List<Integer> validateWinnerNumbers(String input) {
        String[] numbers = input.split(SEPERATOR);
        List<Integer> winnerNumbers = new ArrayList<>();

        for (String elem : numbers) {
            int number = parseInteger(elem);
            validateRange(number);
            winnerNumbers.add(number);
        }

        validateNumbers(winnerNumbers);
        return winnerNumbers;
    }

    public static int validateBonusNumber(List<Integer> winnerNumbers, String input) {
        int bonusNumber = parseInteger(input);
        validateRange(bonusNumber);
        validateDuplicatedBonusNumber(winnerNumbers, bonusNumber);
        return bonusNumber;
    }
}
