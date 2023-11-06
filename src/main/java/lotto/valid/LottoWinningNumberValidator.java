package lotto.valid;

import lotto.models.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumberValidator extends Validator {

    public static List<Integer> winningNumberValidator(String stringWinningNumbers) throws IllegalArgumentException {
        List<String> validatedNumbers = splitAndValidateLength(stringWinningNumbers);
        List<Integer> winningNumbers = convertToInteger(validatedNumbers);

        validateRange(winningNumbers);
        validateDuplicate(winningNumbers);

        return winningNumbers;
    }

    public static int bonusNumberValidator(Lotto lotto, String bonusNumber) throws IllegalArgumentException {
        int validatedBonusNumber = isNumeric(bonusNumber);

        validateRange(validatedBonusNumber);
        validateDuplicateBonusNumber(lotto, validatedBonusNumber);

        return validatedBonusNumber;
    }

    private static void validateDuplicateBonusNumber(Lotto lotto, int validatedBonusNumber) throws IllegalArgumentException {
        if (lotto.getNumbers().contains(validatedBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void validateRange(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
        }
    }

    private static void validateRange(List<Integer> winningNumbers) throws IllegalArgumentException {
        winningNumbers.forEach(LottoWinningNumberValidator::validateRange);
    }

    private static void validateDuplicate(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private static List<Integer> convertToInteger(List<String> validatedNumbers) throws IllegalArgumentException {
        try {
            return validatedNumbers.stream()
                    .map(LottoWinningNumberValidator::isNumeric)
                    .collect(Collectors.toList());
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
