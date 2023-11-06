package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;
import lotto.exception.LottoExceptionMessage;

public class InputView {
    public int inputPurchasePrice() {
        while (true) {
            System.out.println(Message.INPUT_PURCHASE_PRICE.getMessage());
            String inputPrice = Console.readLine().trim();
            Integer validPrice = parseValidPrice(inputPrice);
            if (validPrice != null) {
                return validPrice;
            }
        }
    }

    private Integer parseValidPrice(String inputPrice) {
        try {
            if (validatePurchasePrice(inputPrice)) {
                return Integer.parseInt(inputPrice);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LottoExceptionMessage.MUST_BE_NUMBER.getMessage());
        }
        return null;
    }

    private boolean validatePurchasePrice(String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoExceptionMessage.MUST_BE_NUMBER.getMessage());
        }
    }
}
