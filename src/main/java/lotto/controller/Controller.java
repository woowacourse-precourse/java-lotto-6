package lotto.controller;

import lotto.model.LottoTicket;
import lotto.view.InputView;

public class Controller {
    InputView inputView;
    int ticketCount;
    private static final String ERROR = "[ERROR] ";

    public void run(){
        lottoSetting();
    }

    private void lottoSetting() {
        while (true) {
            String moneyInput = InputView.inputMoney();
            try {
                LottoTicket lottoTicket = new LottoTicket(moneyInput);
                this.ticketCount = lottoTicket.getTicketCount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }
}
