package lotto.view;

import lotto.dto.PurchaseAmountRequest;

public class InputMapper {

    public PurchaseAmountRequest inputToPurchaseAmountRequest(String input) {
        return new PurchaseAmountRequest(Integer.valueOf(input));
    }
}
