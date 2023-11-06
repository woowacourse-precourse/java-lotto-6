package lotto.model;

public class BonusNumber {
    private static final String ERROR_INVALID_INPUT_TYPE = "유효하지 않은 타입입니다. 숫자로 입력해주세요.";
    private static final String ERROR_NULL_OR_EMPTY_INPUT = "입력값이 없거나 공백입니다.";
    private static final String ERROR_INPUT_NUMBER_NOT_IN_RANGE = "1-45 사이의 값을 입력해 주세요.";
    private static final String ERROR_DUPLICATED_WITH_WINNING_NUMBER = "보너스 숫자는 당첨번호와 중복될 수 없습니다.";
    private final int bonusNumber;

    public BonusNumber(String bonusNumberString, WinningNumbers winningNumbers) {
        validateNotNullOrEmpty(bonusNumberString);
        int checkingBonusNumber = parseAndValidateSingleNumber(bonusNumberString);
        validateBonusNumber(checkingBonusNumber, winningNumbers);
        this.bonusNumber = checkingBonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateNotNullOrEmpty(String numberStr) {
        if (numberStr == null || numberStr.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY_INPUT);
        }
    }

    private int parseAndValidateSingleNumber(String numberStr) {
        int parsedNumber;
        try {
            parsedNumber = Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_TYPE);
        }
        validateNumberInRange(parsedNumber);
        return parsedNumber;
    }

    private void validateNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_INPUT_NUMBER_NOT_IN_RANGE);
        }
    }

    private void validateBonusNumber(int number, WinningNumbers winningNumbers) {
        if (winningNumbers.getWinningNumbers().contains(number)) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_WITH_WINNING_NUMBER);
        }
    }
}