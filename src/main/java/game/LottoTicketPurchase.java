package game;

import static constant.ConstantMessage.PURCHASE_AMOUNT_REQUEST_MESSAGE;

import base.Converter;
import camp.nextstep.edu.missionutils.Console;

public class LottoTicketPurchase {
    public int getPurchaseAmount() {
        Converter converter = new Converter();
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
        String purchaseAmountString = Console.readLine();
        return converter.stringToInteger(purchaseAmountString); // 800
    }
}