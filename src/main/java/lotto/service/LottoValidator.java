package lotto.service;

public class LottoValidator {
    public static void isNothingInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.NOTHING_WAS_ENTERED);
        }
    }

    public static void isDigitInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (target == ' ') {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.EXIST_BLANK);
            }
            if (!Character.isDigit(target)) {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.INPUT_IS_NOT_NUMBER);
            }
        }
    }

    public static void isThousandIncrement(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE + Constant.PURCHASE_AMOUNT_IS_NOT_1000_INCREMENT);
        }
    }

    public boolean checkPurchaseAmountInput(String input) {
        boolean check = true;
        try {
            isNothingInput(input);
            isDigitInput(input);
            isThousandIncrement(input);
        } catch (IllegalArgumentException e) {
            check = false;
            System.out.println(e.getMessage());
        }
        return check;
    }
}
