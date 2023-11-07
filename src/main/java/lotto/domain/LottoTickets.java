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

    public Result calculateLottoRank(WinningNumber winningNumber, BonusNumber bonusNumber) {
        List<LottoRanking> ranking = lottoTickets.stream()
                .map(lotto -> winningNumber.calculateLottoRanking(lotto, bonusNumber))
                .toList();
        return new Result(ranking);
    }

    private List<Lotto> createLottoTickets(int ticketAmount) {
        List<Lotto> tickets = new ArrayList<>();
        IntStream.range(0, ticketAmount).forEach(i ->
            tickets.add(new Lotto(generateRandomNumbers())));
        return tickets;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(Constants.MIN_NUMBER,
            Constants.MAX_NUMBER, Constants.LOTTO_SIZE));
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
