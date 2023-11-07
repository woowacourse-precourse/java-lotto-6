package lotto.service;

import static lotto.util.Censor.validateAnnouncementNumber;
import static lotto.util.Censor.validatePurchaseUnit;
import static lotto.util.rule.GameRule.RANK_SIZE;
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

    public Integer getPurchaseAmount() {
        return memoryTicketRepository.findAll().size() * TICKET_PRICE.getValue();
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

    public int[] prizeCount() {
        int[] prizeCount = new int[RANK_SIZE.getValue()];
        List<Ticket> tickets = memoryTicketRepository.findAll();
        for (Ticket ticket : tickets) {
            int matchCount = matchNumbers(ticket);
            boolean hasBonus = hasBonus(ticket);
            if (hasBonus) {
                matchCount++;
            }
            if (matchCount == 6) {
                if (hasBonus) {
                    prizeCount[1]++; // 2등
                } else {
                    prizeCount[0]++; // 1등
                }
            }
            if (matchCount == 5) {
                prizeCount[2]++; // 3등
            }
            if (matchCount == 4) {
                prizeCount[3]++; // 4등
            }
            if (matchCount == 3) {
                prizeCount[4]++; // 5등
            }
        }
        return prizeCount;
    }

    private int matchNumbers(Ticket ticket) {
        List<Integer> winningTicket = memoryTicketRepository.findNumbers().getLotto().getNumbers();
        int matchCount = 0;
        for (Integer number : ticket.getLotto().getNumbers()) {
            if (winningTicket.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean hasBonus(Ticket ticket) {
        Integer bonusNumber = memoryTicketRepository.findBonusNumber().getBonusNumber();
        List<Integer> ticketNumbers = ticket.getLotto().getNumbers();
        return ticketNumbers.contains(bonusNumber);
    }

}
