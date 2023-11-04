package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoTicketMaker {

    private static final int PRICE_PER_LOTTO = 1_000;

    public List<Lotto> issueLottoTickets(Money money) {
        List<Lotto> lottoTickets = new ArrayList<>();
        IntStream.range(0, getIssueCount(money))
                .forEach(i -> lottoTickets.add(new Lotto(LottoNumberGenerator.generate())));

        return Collections.unmodifiableList(lottoTickets);
    }

    private int getIssueCount(Money money) {
        return money.amount() / PRICE_PER_LOTTO;
    }
}
