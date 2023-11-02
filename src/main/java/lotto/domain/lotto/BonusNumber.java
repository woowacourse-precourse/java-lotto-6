package lotto.domain.lotto;

public class BonusNumber {
    private static final String bonusNumberRegex = "\\d";

    private final int number;

    public BonusNumber(String bonusNumber) {
        validate(bonusNumber);
        this.number = Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber) {
        validateFormat(bonusNumber);
    }

    private void validateFormat(String bonusNumber) {
        if (!bonusNumber.matches(bonusNumberRegex)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 숫자만 입력해야 합니다.");
        }
    }
}
