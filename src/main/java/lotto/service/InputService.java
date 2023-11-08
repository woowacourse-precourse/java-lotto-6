package lotto.service;

import lotto.constant.Message.InputMessage;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;

public class InputService {
    private Buyer buyer;
    public void inputPurchaseAmount() {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(InputMessage.REQUEST_PURCHASE_AMOUNT_MESSAGE.getInputMessage());
                buyer = new Buyer(Console.readLine().trim());
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
