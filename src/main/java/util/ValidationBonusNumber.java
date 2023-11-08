package util;

public class ValidationBonusNumber {

    private ValidationBonusNumber() {

    }

    public static void validateBonusNumber(String bonusNumberString) {
        validateNumber(bonusNumberString);
    }

    private static void validateNumber(String bonusNumberString) {
        try {
            Integer price = Integer.parseInt(bonusNumberString);
        } catch (NumberFormatException notANumberException) {
            throw new IllegalArgumentException(ValidationBonusNumberMessages.NOT_A_NUMBER.getMessage());
        }
    }
}
