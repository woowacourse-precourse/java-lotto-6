package lotto.domain;

import static lotto.utils.constants.LottoConstants.LOTTO_TICKET_PRICE;

import lotto.utils.Converter;
import lotto.utils.PurchaseAmountValidator;

public class PurchaseAmountCalculator {

    public int getTicketQuantity(String inputValue) {
        int purchaseAmount = Converter.convertStringToInt(inputValue);
        PurchaseAmountValidator.validate(purchaseAmount);
        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

}
