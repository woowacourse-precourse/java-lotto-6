package lotto.service;

import lotto.constant.Message.InputMessage;
import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Sign;
import lotto.domain.Buyer;

public class InputService {
    private Buyer buyer;
    public Buyer inputPurchaseAmount() {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(InputMessage.REQUEST_PURCHASE_AMOUNT_MESSAGE.getInputMessage());
                buyer = new Buyer(Console.readLine().trim());
                validInput = true;
                return buyer;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
