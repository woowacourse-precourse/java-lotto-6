package lotto.service;

import static lotto.util.constant.GameRule.TICKET_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.repository.MemoryTicketRepository;
import lotto.util.AutomaticGenerator;

public class TicketSevice {

    private final MemoryTicketRepository memoryTicketRepository = new MemoryTicketRepository();

    public int purchaseAmount(Integer money) {
        return money / TICKET_PRICE.getValue();
    }

    public Ticket automaticPurchase() {
        Ticket ticket = new Ticket();
        ticket.setTicket(new Lotto(AutomaticGenerator.generateLottoNumbers()));
        return memoryTicketRepository.purchase(ticket);
    }

    /**
     * 저장된 티켓을 모두 조회하는 기능
     */
    public List<Ticket> findTickets() {
        return memoryTicketRepository.findAll();
    }

}
