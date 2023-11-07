package lotto.controller;

import lotto.constant.Announcer;
import lotto.exception.PurchaseException;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class Setting {

    private Input input = Input.getInput();
    private Output output = Output.getOutput();
    private PurchaseException purchaseException = PurchaseException.getPurchaseException();
    private ProviderRandomValue providerRandomValue;

    public Setting() {
        providerRandomValue = new ProviderRandomValue();
    }

    public int purchaseLotto() {
        output.printMessage(Announcer.PURCHASE_PAYMENT.getMessage());
        String payment = input.inputFromUser();

        manageException(payment);

        int purchaseNumber = Integer.parseInt(payment) / 1000;

        output.printMessage(Announcer.PURCHASE_COUNT.getFormat(purchaseNumber));

        return purchaseNumber;
    }

    private void manageException(String payment) {
        isMinimumPayment(payment);
        isUnitOfThousane(payment);
    }

    private void isMinimumPayment(String payment) {
        if (Integer.parseInt(payment) < 1000) {
            purchaseException.minimumPay();
        }
    }

    private void isUnitOfThousane(String payment) {
        int value = Integer.parseInt(payment) % 1000;

        if (value != 0) {
            purchaseException.payThousand();
        }
    }

    public List<Integer> pickLotto() {
        return providerRandomValue.provideLotto();
    }

}
