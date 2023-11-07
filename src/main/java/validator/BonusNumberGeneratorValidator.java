package validator;

public class BonusNumberGeneratorValidator {
    public static final String INVALID_BONUS_NUMBER_RANGE = "[ERROR] 보너스 숫자에는 1 ~ 45까지의 숫자만 입력해주세요.";
    public static final String INVALID_NON_NUMERIC_INPUT = "[ERROR] 로또 구입 금액에는 숫자만 입력해주세요.";

    public void vaildBonusNumber(String bonusNumber) {
        vaildBonusNumberNonNumeric(bonusNumber);
        int bonusNumberValue = Integer.parseInt(bonusNumber);
        vaildBonusNumberNonNumeric(bonusNumber);
    }

    void vaildBonusNumberRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_RANGE);
        }
    }

    void vaildBonusNumberNonNumeric(String input) {
        String regex = "[+-]?\\d*(\\.\\d+)?";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(INVALID_NON_NUMERIC_INPUT);
        }
    }
}
