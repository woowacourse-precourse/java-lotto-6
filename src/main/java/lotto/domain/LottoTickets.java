package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<LottoRank> getWiningRanks(WinningLottoNumbers winningLottoNumbers) {
        return IntStream.range(0, numberOfLottoTickets)
                .mapToObj(i -> getWiningRank(winningLottoNumbers, i))
                .collect(Collectors.toList());
    }

    private LottoRank getWiningRank(WinningLottoNumbers winningLottoNumbers, int index) {
        return LottoRank.get(winningLottoNumbers, lottoTickets.get(index));
    }

    private void buyLottoTickets() {
        lottoTickets.add(LottoGenerator.generate());
    }
}
