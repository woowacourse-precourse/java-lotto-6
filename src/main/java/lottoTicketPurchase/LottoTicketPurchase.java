package lottoTicketPurchase;

import static constant.ErrorMessage.NOT_NUMBER;
import static constant.RequestMessage.PURCHASE_AMOUNT_REQUEST_MESSAGE;

import base.Converter;
import camp.nextstep.edu.missionutils.Console;

public class LottoTicketPurchase {
    Converter converter = new Converter();

    public int getPurchaseAmount() {
        while (true) {
            String purchaseAmountString = receivePurchaseAmountString();
            final String REGEX = "[0-9]+";

            if (purchaseAmountString.matches(REGEX)) {
                return converter.stringToInteger(purchaseAmountString);
            }
                System.out.println(NOT_NUMBER);
            }
        }

    private String receivePurchaseAmountString() {
        printPurchaseAmountRequestMessage();
        return Console.readLine();
    }

    private void printPurchaseAmountRequestMessage() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
    }
}


