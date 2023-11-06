package lottoTicketPurchase;

import static constant.RequestMessage.PURCHASE_AMOUNT_REQUEST_MESSAGE;

import base.Converter;
import camp.nextstep.edu.missionutils.Console;

public class LottoTicketPurchase {
    public int getPurchaseAmount(Converter converter) {
        String purchaseAmountString = receivePurchaseAmountString();
        return converter.stringToInteger(purchaseAmountString); // 800
    }

    private String receivePurchaseAmountString() {
        printPurchaseAmountRequestMessage();
        return Console.readLine();
    }

    private void printPurchaseAmountRequestMessage() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
    }
}