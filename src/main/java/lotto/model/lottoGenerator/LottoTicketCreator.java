package lotto.model.lottoGenerator;


import java.util.ArrayList;
import java.util.List;

public class LottoTicketCreator {
    private final LottoNumberGenerator numberGenerator;
    private final LottoTicketCalculator ticketCalculator;

    public LottoTicketCreator() {
        this.numberGenerator = new LottoNumberGenerator();
        this.ticketCalculator = new LottoTicketCalculator();
    }

    public List<Lotto> createLottoTickets(int purchaseAmount) {
        int ticketCount = ticketCalculator.calculateNumberOfTickets(purchaseAmount);
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(numberGenerator.generateNumbers()));
        }

        return tickets;
    }
}