package lotto.service;

import static lotto.util.Censor.validatePurchaseUnit;
import static lotto.util.Censor.validateAnnouncementNumber;
import static lotto.util.rule.GameRule.TICKET_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.domain.WinningTicket;
import lotto.repository.MemoryTicketRepository;
import lotto.util.AutomaticGenerator;

public class TicketService {

    private final MemoryTicketRepository memoryTicketRepository;

    public TicketService(MemoryTicketRepository memoryTicketRepository) {
        this.memoryTicketRepository = memoryTicketRepository;
    }

    public Integer purchaseAmount(String input) {
        Integer money = Integer.parseInt(input);
        validatePurchaseUnit(money);
        return money / TICKET_PRICE.getValue();
    }

    public Ticket automaticPurchase() {
        Ticket ticket = new Ticket();
        ticket.setTicket(new Lotto(AutomaticGenerator.generateLottoNumbers()));
        return memoryTicketRepository.purchase(ticket);
    }

    public WinningTicket announcementNumber(String input) {
        WinningTicket ticket = new WinningTicket();
        List<Integer> numbers = getWinningNumbers(input);
        validateAnnouncementNumber(numbers);
        ticket.setNumbers(new Lotto(numbers));
        return memoryTicketRepository.announcement(ticket);
    }

    private List<Integer> getWinningNumbers(String input) {
        String[] numberStrings = input.split(",");
        return Arrays.stream(numberStrings)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
