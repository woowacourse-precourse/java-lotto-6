package lotto.util;

import java.util.HashSet;
import java.util.Set;

public class InputValidation {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    // 입력값이 Null Or 빈 문자열일 경우
    public static void validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "입력값은 null 이나 빈 문자열일 수 없습니다.");
        }
    }

    // 입력값이 정수일 경우
    public static void validationStringInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자를 입력해주세요.");
        }
    }

    // 입력값이 1,000원 단위로 떨어지지 않을 경우
    public static void validateMoneyInput(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "1,000원 단위로 입력해주세요.");
        }
    }

    // 당첨 번호는 "," 로 구분되야함.
    public static void validateCommaSeparatedInput(String input) {
        String replaceAll = input.replaceAll("[0-9,]", "");
        if (replaceAll.length() != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "당첨 번호는 쉼표(,) 를 기준으로 숫자만 입력하세요.");
        }
    }

    // 당첨 번호는 6개여야함.
    public static void validateInputSize(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }

    // 각 당첨 번호의 숫자가 1이상 45이하만 가능함.
    public static void validateInputRange(String input) {
        String[] numbers = input.split(",");

        for (String number : numbers) {
            int i = Integer.parseInt(number);
            if (1 > i || i > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // 각 당첨 번호의 숫자가 중복되어서는 안 됨.
    public static void validateDuplicateValues(String input) {
        String[] numbers = input.split(",");

        Set<String> uniqueElements = new HashSet<>();

        for (String number : numbers) {
            if (!uniqueElements.add(number)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "로또 번호가 중복되어서는 안 됩니다.");
            }

        }
    }

    public static void validateDuplicateBonusNumber(String winningNumber, String bonusNumber) {
        String[] winningNumbers = winningNumber.split(",");

        for (String number : winningNumbers) {
            if (number.equals(bonusNumber)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }

        }
    }
}
