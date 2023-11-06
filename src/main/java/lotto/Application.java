package lotto;

import lotto.controller.LottoManager;
import lotto.service.TicketSevice;

public class Application {

    public static void main(String[] args) {

        TicketSevice ticketSevice = new TicketSevice();
        LottoManager lottoManager = new LottoManager(ticketSevice);
        lottoManager.run();

    }

}
