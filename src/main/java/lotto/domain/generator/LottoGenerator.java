package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> generateLottos(long purchaseAmount) {
        int numberOfTickets = (int) (purchaseAmount / LOTTO_PRICE);
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(generateLotto());
        }

        return tickets;
    }

    private Lotto generateLotto() {
        RandomListGenerator generator = new RandomListGenerator();
        return new Lotto(generator.generateNumbers());
    }
}