package lotto.service;

import static lotto.util.constant.GameRule.TICKET_PRICE;

import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.repository.MemoryTicketRepository;
import lotto.util.AutomaticGenerator;
import lotto.util.Censor;

public class TicketService {

    private final MemoryTicketRepository memoryTicketRepository;

    public TicketService(MemoryTicketRepository memoryTicketRepository) {
        this.memoryTicketRepository = memoryTicketRepository;
    }

    public int purchaseAmount(Integer money) {
        Censor.validatePurchaseUnit(money);
        return money / TICKET_PRICE.getValue();
    }

    public Ticket automaticPurchase() {
        Ticket ticket = new Ticket();
        ticket.setTicket(new Lotto(AutomaticGenerator.generateLottoNumbers()));
        return memoryTicketRepository.purchase(ticket);
    }

}
