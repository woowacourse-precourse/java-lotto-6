package validator;

public class BonusNumberValidator {
    public static void bonusNumberValidate(String bounusNumber) {
        bonusNumberNotNull(bounusNumber);
    }

    private static void bonusNumberNotNull(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }
}
