package lotto.model;

import lotto.Lotto;
import lotto.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private final RandomNumberGenerator numberGenerator;

    public LottoTickets(RandomNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void createTicket(int ticketPiecesCount) {
        while (ticketPiecesCount-- > 0) {
            lottoTickets.add(new Lotto(numberGenerator.getRandomNumbers()));
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
