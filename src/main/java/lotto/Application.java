package lotto;

import lotto.controller.LottoManager;
import lotto.repository.MemoryTicketRepository;
import lotto.service.TicketService;

public class Application {

    public static void main(String[] args) {

        MemoryTicketRepository repository = new MemoryTicketRepository();
        TicketService sevice = new TicketService(repository);
        LottoManager lottoManager = new LottoManager(sevice);
        lottoManager.run();

    }

}
