package lotto;

import static lotto.constants.ProgramMessage.REQUEST_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;

public class LottoTerminal {
    private long amountPaid;

    public String requestAndReadPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT.getMessage());

        return Console.readLine();
    }

    public void receivePayment(long amountPaid) {
        this.amountPaid = amountPaid;
    }
}
