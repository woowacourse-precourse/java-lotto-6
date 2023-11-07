package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoErrorMessage;

import static lotto.model.LottoConfig.LOTTO_PRICE;

public class LottoInputView {
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
            try {
                price = parsePriceInput(input);
            } catch (NumberFormatException e) {
                LottoErrorMessage.INVALID_PURCHASE_INPUT.printMessage();
                continue;
            }
            validInput = isValidPrice(price);
        }
        return price;
    }

    private int parsePriceInput(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    private boolean isValidPrice(int price) {
        if (price % LOTTO_PRICE != 0 || price <= 0) {
            LottoErrorMessage.INVALID_PURCHASE_AMOUNT.printMessage();
            return false;
        }
        return true;
    }
}
