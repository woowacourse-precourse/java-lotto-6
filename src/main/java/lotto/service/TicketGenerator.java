package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class TicketGenerator {
    private final NumberGenerator numberGenerator;

    public TicketGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static TicketGenerator create(NumberGenerator numberGenerator) {
        return new TicketGenerator(numberGenerator);
    }

    public List<Lotto> generateLottoTicket(int purchaseAmount) {
        int totalTicketCount = purchaseAmount / Lotto.LOTTO_PRICE;
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < totalTicketCount; i++) {
            List<Integer> lottoNumbers = numberGenerator.generateLottoNumber();
            Lotto lottoTicket = new Lotto(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }

        return lottoTickets;
    }
}
