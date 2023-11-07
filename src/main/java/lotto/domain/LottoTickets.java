package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.util.LottoGenerator;

public class LottoTickets {

    private final List<Lotto> lottoTickets = new ArrayList<>();
    private final int numberOfLottoTickets;

    public LottoTickets(Payment payment) {
        numberOfLottoTickets = payment.numberLottoTicketsCanBuy();
        for (int i = 0; i < numberOfLottoTickets; i++) {
            buyLottoTickets();
        }
    }

    public int getNumberOfLottoTickets() {
        return numberOfLottoTickets;
    }

    public List<LottoRank> getWinningRanks(WinningLottoNumbers winningLottoNumbers) {
        List<LottoRank> ranks = new ArrayList<>();

        for (int i = 0; i < numberOfLottoTickets; i++) {
            ranks.add(getWinningRank(winningLottoNumbers, i));
        }

        return ranks;
    }

    private LottoRank getWinningRank(WinningLottoNumbers winningLottoNumbers, int index) {
        return LottoRank.get(winningLottoNumbers, lottoTickets.get(index));
    }

    private void buyLottoTickets() {
        lottoTickets.add(LottoGenerator.generate());
    }

    @Override
    public String toString() {
        return String.join("\n", IntStream.range(0, numberOfLottoTickets)
                .mapToObj(i -> lottoTickets.get(i).toString())
                .toList());
    }
}
