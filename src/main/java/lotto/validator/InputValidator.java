package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class InputValidator {

    public static void validateBudget(String inputBudget) {

        try {
            int budget = Integer.parseInt(inputBudget);

            if (budget % Lotto.PRICE != 0) {
                throw new IllegalArgumentException("1000 원으로 나누어 떨어지지 않는 구입금액 입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식의 구입금액 입니다.");
        }
    }

    public static void validateWinningNumber(String winningNumberInput) {

        List<String> numbers = Arrays.asList(winningNumberInput.split(","));

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("잘못된 개수의 입력값");
        }

        for (String number : numbers) {
            try {
                Integer parsedNumber = Integer.parseInt(number);
                validateRange(parsedNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("정수가 아닌 숫자가 포함되어 있습니다.");
            }
        }

        validateDuplicate(numbers);
    }

    public static void validateBonusNumber(String bonusNumberInput, List<Integer> winningNumbers) {

        try {
            Integer bonusNumber = Integer.parseInt(bonusNumberInput);
            validateRange(bonusNumber);

            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식의 보너스 번호 입니다.");
        }
    }

    public static void validateRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("범위를 벗어난 로또 번호입니다.");
        }
    }

    public static void validateDuplicate(List<String> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }
}
