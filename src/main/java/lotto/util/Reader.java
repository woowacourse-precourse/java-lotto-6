package lotto.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.error.ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT;

public class Reader {
    public Integer purchaseAmount() {
        String purchaseAmount = readLine();
        return validFormatAndConvert(purchaseAmount, INVALID_PURCHASE_AMOUNT_FORMAT);
    }

    private Integer validFormatAndConvert(String input, String error) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(error);
        }
    }

}
