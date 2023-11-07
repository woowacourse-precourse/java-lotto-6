package validator;

public class BonusNumberGeneratorValidator {
    void vaildBonusNumberRange(int bonusNumber) {
        if (bonusNumber > 9 || bonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자에는 1 ~ 9까지의 숫자만 입력해주세요.");
        }
    }

    void vaildBonusNumberNonNumeric(String input) {
        String regex = "[+-]?\\d*(\\.\\d+)?";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액에는 숫자만 입력해주세요.");
        }
    }
}
