package lotto.validation;

import java.util.List;

public class NumberCheckValidator {
    private static final String ERROR = "[ERROR] ";
    public static void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR + "6개의 숫자를 골라주세요");
        }
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ERROR + "중복되지 않는 숫자를 골라주세요");
        }
        if (winningNumbers.stream().anyMatch(i -> i < 1 || i > 45)) {
            throw new IllegalArgumentException(ERROR + "1 ~ 45 사이의 숫자를 골라주세요");
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR + "당첨번호와 중복 될 수 없습니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR + "1 ~ 45 사이 숫자를 골라 주세요");
        }
    }
}