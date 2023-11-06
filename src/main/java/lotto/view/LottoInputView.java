package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoErrorMessage;

public class LottoInputView {
    private static final int LOTTO_PRICE = 1000;

    public int purchasePriceInput() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = getPriceInput();
        return price;
    }

    private int getPriceInput() {
        boolean validInput = false;
        int price = 0;
        while (!validInput) {
            String input = Console.readLine();
            price = parsePriceInput(input);
            if(isValidPrice(price)) {
                validInput = true;
            }
        }
        return price;
    }

    private int parsePriceInput(String input) {
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            LottoErrorMessage.INVALID_PURCHASE_INPUT.printMessage();
            return 0;
        }
    }

    private boolean isValidPrice(int price) {
        if(price % LOTTO_PRICE != 0) {
            LottoErrorMessage.INVALID_PURCHASE_AMOUNT.printMessage();
            return false;
        }
        return true;
    }
}
