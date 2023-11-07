package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class TicketGenerator {
    private final NumberGenerator numberGenerator;

    public TicketGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public static TicketGenerator create(NumberGenerator numberGenerator) {
        return new TicketGenerator(numberGenerator);
    }

    public List<List<Integer>> generateLottoTicket(int purchaseAmount) {
        int totalTicketCount = purchaseAmount / 1000; // 하드코딩 상수 대체
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < totalTicketCount; i++) {
            List<Integer> lottoNumbers = numberGenerator.generateLottoNumber();
            lottoTickets.add(lottoNumbers);
        }

        return lottoTickets;
    }
}
