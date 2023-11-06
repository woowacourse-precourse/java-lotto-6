package lotto.view;

import lotto.exception.BuyLottoException;

public class BuyLottoInput {

    private static final String BUY_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";

    public static int buyLottoInput() {
        System.out.println(BUY_LOTTO_MESSAGE);
        String price = UserInput.userInput();
        System.out.println("");
        int money = validatePrice(price);
        return tickets(money);
    }

    public static int validatePrice(String price) {
        try {
            validateInteger(price);
            validateOverZero(price);
            validateKilo(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + System.lineSeparator());
            return buyLottoInput();
        }
        return Integer.parseInt(price);
    }

    public static void validateInteger(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            BuyLottoException.buyIntegerException();
        }
    }

    public static void validateKilo(String price) {
        if (Integer.parseInt(price) % 1000 != 0) {
            BuyLottoException.buyKiloException();
        }

    }

    public static void validateOverZero(String price) {
        if (Integer.parseInt(price) < 1000) {
            BuyLottoException.buyOverzeroException();
        }

    }

    public static int tickets(int money) {
        return money / 1000;
    }

}
