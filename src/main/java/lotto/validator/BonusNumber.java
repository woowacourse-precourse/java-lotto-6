package lotto.validator;

public class BonusNumber {
    private static final String ERROR_INVALID_INPUT_TYPE = "유효하지 않은 입력입니다. 공백을 제외한 숫자로 입력해주세요";
    private static final String ERROR_NULL_INPUT = "입력값이 없습니다. 숫자를 입력해 주세요.";
    private static final String ERROR_INPUT_NUMBER_NOT_IN_RANGE = "1-45 사이의 값을 입력해 주세요.";
    private static final String ERROR_DUPLICATED_WITH_WINNING_NUMBER = "보너스 숫자는 당첨번호와 중복될 수 없습니다.";
    private final int bonusNumber;

    public BonusNumber(String bonusNumberInput, WinningNumbers winningNumbers) {
        validateNotNull(bonusNumberInput);
        int parsedBonusNumber = parseBonusNumber(bonusNumberInput);
        validateBonusNumber(parsedBonusNumber, winningNumbers);
        this.bonusNumber = parsedBonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNotNull(String bonusNumberInput) {
        if (bonusNumberInput == null || bonusNumberInput.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_INPUT);
        }
    }

    private int parseBonusNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_TYPE);
        }
    }

    private void validateBonusNumber(int parsedBonusNumber, WinningNumbers winningNumbers) {
        validateNumberInRange(parsedBonusNumber);
        validateNotInWinningNumbers(parsedBonusNumber, winningNumbers);
    }

    private void validateNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER_NOT_IN_RANGE);
        }
    }

    private void validateNotInWinningNumbers(int bonusNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.getWinningNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_WITH_WINNING_NUMBER);
        }
    }
}