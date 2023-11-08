package validator;

public class BonusNumberValidator {
    public static void bonusNumberValidate(String bonusNumber) {
        bonusNumberNotNull(bonusNumber);
        bonusNumberRange(bonusNumber);
    }

    private static void bonusNumberNotNull(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private static void bonusNumberRange(String bonusNumber) {
        if (!bonusNumber.matches("([1-9]|[1-3][0-9]|4[0-5])")) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 수를 입력해주세요.");
        }
    }
}
