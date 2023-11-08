package lotto;

import lotto.controller.LottoManager;
import lotto.repository.MemoryTicketRepository;
import lotto.service.BonusNumberService;
import lotto.service.TicketService;

public class Application {

    public static void main(String[] args) {

        MemoryTicketRepository repository = new MemoryTicketRepository();
        TicketService ticketService = new TicketService(repository);
        BonusNumberService bonusNumberService = new BonusNumberService(repository);
        LottoManager lottoManager = new LottoManager(ticketService, bonusNumberService);
        lottoManager.run();

    }

}
