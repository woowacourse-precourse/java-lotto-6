package lotto.util;

import java.util.List;

public class Validation {
    private static final String ERROR_MESSAGE = "[ERROR]";

    // 금액에 대한 validation
    public static void validatePrice(String input) {
        validateNumericString(input);
        validateEmptySpace(input);
        int inputNum = Integer.parseInt(input);
        validateDisiblePrice(inputNum);
    }

    private static void validateNumericString(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값은 숫자여야 합니다.");
        }
    }

    private static void validateEmptySpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값은 빈칸이 될 수 없습니다.");
        }
    }

    private static void validateDisiblePrice(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }


    // 당첨 로또(입력)에 대한 validation
    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumberLength(numbers);
        validateNumberDuplicated(numbers);
        validateNumberRange(numbers);
    }

    private static void validateNumberLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 6자리여야 합니다.");
        }
    }

    private static void validateNumberDuplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 중복될 수 없습니다");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (isInvalid(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static boolean isInvalid(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < 1 || number > 45);
    }


    // 보너스 넘버에 대한 validation 필요
    public static int validateBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {
        int bonusNumber = validateAndParseBonusNumber(bonusNumberInput);
        validateNumberRange(bonusNumber);
        validateNumberNotDuplicated(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validateNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateNumberNotDuplicated(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 로또 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static int validateAndParseBonusNumber(String bonusNumberInput) {
        String numberInput = bonusNumberInput.trim();
        if (!numberInput.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 숫자여야 합니다.");
        }
        return Integer.parseInt(numberInput);
    }
}