package lotto.domain.lotto;

public class BonusNumber {
    private static final String bonusNumberRegex = "\\d";

    private final int number;

    public BonusNumber(String bonusNumber) {
        validate(bonusNumber);
        this.number = parseBonusNum(bonusNumber);
    }

    private void validate(String bonusNumber) {
        validateFormat(bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateFormat(String bonusNumber) {
        if (!bonusNumber.matches(bonusNumberRegex)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 숫자만 입력해야 합니다.");
        }
    }

    private void validateRange(String bonusNumber) {
        int bonusNum = parseBonusNum(bonusNumber);

        if (isInvalidRange(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1~45사이의 숫자여야 합니다.");
        }
    }

    private static int parseBonusNum(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    private boolean isInvalidRange(int bonusNum) {
        return bonusNum < 1 || bonusNum > 45;
    }
}
