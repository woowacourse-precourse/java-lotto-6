package lotto.domain;

public class BonusNumber {
    private static final String BONUS_NUMBER_MUST_NUMERIC_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String bonusNumber) {
        try {
            int convertBonusNumber = Integer.parseInt(bonusNumber);
            return new BonusNumber(convertBonusNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(BONUS_NUMBER_MUST_NUMERIC_MESSAGE);
        }
    }

    public int toInt() {
        return bonusNumber;
    }
}
