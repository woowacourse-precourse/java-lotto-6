package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {
    private final LottoNumberGenerator numberGenerator;

    public LottoTicketGenerator(LottoNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static LottoTicketGenerator create(LottoNumberGenerator numberGenerator) {
        return new LottoTicketGenerator(numberGenerator);
    }

    public List<List<Integer>> generateLottoTicket(int purchaseAmount) {
        int totalTicketCount = purchaseAmount / 1000;
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < totalTicketCount; i++) {
            List<Integer> lottoNumbers = numberGenerator.generateLottoNumber();
            lottoTickets.add(lottoNumbers);
        }

        return lottoTickets;
    }
}
