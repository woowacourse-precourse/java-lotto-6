package lotto.valid;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumberValidator {

    public static List<Integer> winningNumberValidator(String winningNumber) throws IllegalArgumentException {
        List<String> validatedNumbers = splitAndValidateLength(winningNumber);
        List<Integer> winningNumbers = convertToInteger(validatedNumbers);

        validateDuplicate(winningNumbers);

        return winningNumbers;
    }

    public static int bonusNumberValidator(String bonusNumber) throws IllegalArgumentException {
        int validatedBonusNumber = convertToInteger(bonusNumber);

        validateRange(validatedBonusNumber);

        return validatedBonusNumber;
    }

    private static void validateRange(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
        }
    }

    private static void validateDuplicate(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private static List<Integer> convertToInteger(List<String> validatedNumbers) throws IllegalArgumentException {
        try {
            return validatedNumbers.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static int convertToInteger(String validatedNumbers) throws IllegalArgumentException {
        try {
            return Integer.parseInt(validatedNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static List<String> splitAndValidateLength(String winningNumber) throws IllegalArgumentException {
        String[] winningNumbers = winningNumber.split(",");
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
        return List.of(winningNumbers);
    }

}
