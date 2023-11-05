package lotto;

import static lotto.OutputView.printTicketCount;


public class LottoController {
    public void start() {
        int ticketCount = inputLottoMoney();
        printTicketCount(ticketCount);
    }

    private int inputLottoMoney() {
        String inputMoney = InputView.inputRequestMoney();
        return new Money(inputMoney).getTicketCount();
    }
}
