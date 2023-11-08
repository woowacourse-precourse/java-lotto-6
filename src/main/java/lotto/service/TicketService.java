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
import lotto.util.rule.GameRule;

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
        List<Integer> winningNumbers = memoryTicketRepository.findNumbers().getLotto().getNumbers();
        Integer bonusNumber = memoryTicketRepository.findBonusNumber().getBonusNumber();

        for (Ticket ticket : tickets) {
            int matchCount = matchNumbers(ticket, winningNumbers);
            boolean hasBonus = hasBonus(ticket, bonusNumber);
            int prizeRank = calculatePrizeRank(matchCount, hasBonus);

            if (prizeRank >= 0) {
                prizeCount[prizeRank]++;
            }
        }

        return prizeCount;
    }

    private int matchNumbers(Ticket ticket, List<Integer> winningNumbers) {
        List<Integer> ticketNumbers = ticket.getLotto().getNumbers();
        int matchCount = 0;
        for (Integer number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean hasBonus(Ticket ticket, Integer bonusNumber) {
        List<Integer> ticketNumbers = ticket.getLotto().getNumbers();
        return ticketNumbers.contains(bonusNumber);
    }

    private int calculatePrizeRank(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return 0; // 1등
        } else if (matchCount == 5 && hasBonus) {
            return 1; // 2등
        } else if (matchCount == 5|| (matchCount == 4 && hasBonus)) {
            return 2; // 3등
        } else if (matchCount == 4 || (matchCount == 3 && hasBonus)) {
            return 3; // 4등
        } else if (matchCount == 3 || (matchCount == 2 && hasBonus)) {
            return 4; // 5등
        }
        return -1; // 어떤 상금에도 해당하지 않음
    }
}
