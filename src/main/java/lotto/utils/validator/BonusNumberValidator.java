package lotto.utils.validator;

public class BonusNumberValidator {
    public static void validate(String inputBonusNumber) {
        validateNumberFormat(inputBonusNumber);
    }

    private static void validateNumberFormat(String inputBonusNumber) {
        try {
            Integer.parseInt(inputBonusNumber);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException("숫자만");
        }
    }
}
