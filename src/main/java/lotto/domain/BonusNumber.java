package lotto.domain;

public class BonusNumber {
    private static final String BONUS_NUMBER_MUST_NUMERIC_MESSAGE = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    private static final String BONUS_NUMBER_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1~45의 숫자여야 합니다.";
    private static final int START_RANGE_VALUE = 1;
    private static final int END_RANGE_VALUE = 45;

    private final int bonusNumber;


    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String bonusNumber) {
        validateNumeric(bonusNumber);
        int convertedBonusNumber = Integer.parseInt(bonusNumber);
        validateRange(convertedBonusNumber);
        return new BonusNumber(convertedBonusNumber);
    }

    private static void validateNumeric(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(BONUS_NUMBER_MUST_NUMERIC_MESSAGE);
        }
    }

    public static void validateRange(int bonusNumber) {
        if (isOverRange(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_MESSAGE);
        }
    }

    private static boolean isOverRange(int number) {
        return number < START_RANGE_VALUE || number > END_RANGE_VALUE;
    }

    public int toInt() {
        return bonusNumber;
    }
}
