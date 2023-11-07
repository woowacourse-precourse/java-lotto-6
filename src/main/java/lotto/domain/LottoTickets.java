package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.util.Constants;

public class LottoTickets {
    private final List<Lotto> lottoTickets;
    public LottoTickets(int ticketAmount) {
        this.lottoTickets = createLottoTickets(ticketAmount);
    }

    private static List<Lotto> createLottoTickets(int ticketAmount) {
        List<Lotto> tickets = new ArrayList<>();
        IntStream.range(0, ticketAmount).forEach(i ->
            tickets.add(new Lotto(generateRandomNumbers())));
        return tickets;
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_NUMBER,
                Constants.MAX_NUMBER, Constants.LOTTO_SIZE);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
