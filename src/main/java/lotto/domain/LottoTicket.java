package lotto.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTicket(int count) {
        generateTickets(count);
    }

    private void generateTickets(int count) {
        for (int i = 0; i < count; i++) {
            lottoTickets.add(new Lotto());
        }
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public PrizeResult calculateWinningStatistic(PrizeNumbers prizeNumbers) {
        List<Ranking> rankings = lottoTickets.stream()
                .map(prizeNumbers::calculatePrize)
                .filter(Objects::nonNull)
                .peek(System.out::println)
                .collect(toList());
        return new PrizeResult(rankings);
    }
}