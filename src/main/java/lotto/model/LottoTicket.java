package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final List<Lotto> lottoTicket;

    protected LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = new ArrayList<>(lottoTicket);
    }

    protected static LottoTicket createLottoTicket(int count) {
        List<Lotto> lottoTicket = IntStream.range(0, count)
                .mapToObj(element -> Lotto.createLotto())
                .collect(Collectors.toList());

        return new LottoTicket(lottoTicket);
    }

    public WinStatistics getRank(Lotto winLotto, Bonus bonus) {
        WinStatistics winStatistics = new WinStatistics();

        lottoTicket.forEach(
                lotto -> {
                    Rank rank = lotto.getRank(winLotto, bonus);
                    winStatistics.pushRank(rank);
                }
        );

        return winStatistics;
    }

    public String printResult() {
        StringBuilder stringBuilder = new StringBuilder();

        lottoTicket.forEach(
                lotto -> {
                    stringBuilder.append(lotto.getLottoNumber()).append("\r\n");
                }
        );

        return stringBuilder.toString();
    }
}
