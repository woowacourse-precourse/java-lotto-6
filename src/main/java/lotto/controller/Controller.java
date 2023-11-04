package lotto.controller;

import lotto.model.LottoTicket;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    InputView inputView;
    LottoService lottoService;
    int ticketCount;
    private static final String ERROR = "[ERROR] ";

    public void run(){
        lottoTicketSetting();
        showTicketCount();
    }

    private void lottoTicketSetting() {
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

    private void showTicketCount() {
        OutputView.displayTicket_Count(ticketCount);
    }

}
