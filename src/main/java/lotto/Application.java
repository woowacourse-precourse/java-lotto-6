package lotto;

import lotto.presentation.controller.MC;
import lotto.presentation.view.View;
import lotto.repository.LottoTicketRepository;
import lotto.service.Referee;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        LottoTicketRepository ticketRepository = LottoTicketRepository.getInstance();
        Referee referee = new Referee(ticketRepository);
        MC mc = new MC(view, referee, ticketRepository);
        mc.run();
    }
}