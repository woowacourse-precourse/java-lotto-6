package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println(InputMessage.purchaseAmount);
        String purchaseAmount = Console.readLine();
    }

    public void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.REQUIRED_VALUE);
        }
    }

    public void checkNumber(String input) {
        try {
            int parsedInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
        }
    }

    public void checkUnit(int purchaseAmount) {
        if (purchaseAmount % LottoNumbers.PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT);
        }
    }

    public void checkZero(int purchaseAmount) {
        if (purchaseAmount < LottoNumbers.PURCHASE_AMOUNT_MIN) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ZERO);
        }
    }
}
