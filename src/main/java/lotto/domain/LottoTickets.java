package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    private LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public static LottoTickets buy(int amount) {
        int numberOfLotto = amount / 1_000;
        List<Lotto> tickets = IntStream.range(0, numberOfLotto)
                .mapToObj(i -> generateRandomLotto())
                .collect(Collectors.toList());

        return new LottoTickets(tickets);
    }

    private static Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }

    public List<Lotto> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }
}
