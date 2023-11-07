package lotto.util;

public class Validator {
    public static void validateLottoPurchaseAmount(String input) {
        validateIsInteger(input);
        validateIsDivide(Integer.parseInt(input));
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            String message = ExceptionMessage.WIN_LOTTO_INTEGER.getMessage();
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateIsDivide(int input) {
        if (input % Constant.AMOUNT_ONE_LOTTO != 0) {
            String message = ExceptionMessage.LOTTO_PURCHASE_AMOUNT_DIVIDE.getMessage();
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateLottoResult(String input) {
        String[] lottoResult = input.split(Constant.SPLIT_UNIT);
    }
}
