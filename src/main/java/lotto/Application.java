package lotto;

import lotto.presentation.controller.LottoGameController;
import lotto.presentation.view.View;
import lotto.repository.LottoTicketRepository;
import lotto.service.Referee;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        LottoTicketRepository ticketRepository = LottoTicketRepository.getInstance();
        Referee referee = new Referee(ticketRepository);
        LottoGameController lottoGameController = new LottoGameController(view, referee, ticketRepository);

        lottoGameController.run();
    }
}