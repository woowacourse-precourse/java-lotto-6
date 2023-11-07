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
            try {
                return validateAndConverter(purchaseAmountString);
            } catch (IllegalArgumentException error) {
                System.out.println(NOT_NUMBER);
            }
        }
    }

    private String receivePurchaseAmountString() {
        printPurchaseAmountRequestMessage();
        return Console.readLine();
    }

    private void printPurchaseAmountRequestMessage() {
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
    }

    private int validateAndConverter(String purchaseAmountString) {
        try {
            return converter.stringToInteger(purchaseAmountString);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException();
        }
    }
}