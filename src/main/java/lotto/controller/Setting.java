package lotto.controller;

import lotto.constant.Announcer;
import lotto.exception.PurchaseException;
import lotto.view.Input;
import lotto.view.Output;

public class Setting {

    private Input input = Input.getInput();
    private Output output = Output.getOutput();
    private PurchaseException purchaseException = PurchaseException.getPurchaseException();

    public Setting() {
    }

    public int purchaseLotto() {
        output.printMessage(Announcer.PURCHASE_PAYMENT.getMessage());
        String payment = input.inputFromUser();

        manageException(payment);

        return Integer.parseInt(payment);
    }

    private void manageException(String payment) {
        isMinimumPayment(payment);
        isUnitOfThousane(payment);
    }

    private void isMinimumPayment(String payment) {
        if(Integer.parseInt(payment) < 1000) {
            purchaseException.minimumPay();
        }
    }

    private void isUnitOfThousane(String payment) {
        int value = Integer.parseInt(payment) % 1000;

        if(value != 0){
            purchaseException.payThousand();
        }
    }
}
