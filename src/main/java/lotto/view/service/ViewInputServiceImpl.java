package lotto.view.service;

import lotto.validator.InputValidator;
import lotto.view.message.InputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ViewInputServiceImpl implements ViewInputService {

    @Override
    public void printMessagePurchaseAmount() {
        System.out.println(InputMessage.MESSAGE_PURCHASE_AMOUNT.getValue());
    }

    @Override
    public int inputPurchaseAmount() {
        int res = 0;
        try {
            res = Integer.parseInt(InputValidator.validInputPurchaseAmount(readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchaseAmount();
        } finally {
            return res;
        }
    }
}
