package lotto.domain;

import lotto.domain.lotto.LottoTicket;

import java.util.EnumMap;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WinningResult {

    private Map<Ranking, Long> result;
    private double rateOfReturnPercent;

    private WinningResult(LottoTicket lottoTicket, WinningLotto winningLotto) {
        saveWinningResult(lottoTicket, winningLotto);
        saveRateOfReturnPercent(lottoTicket);
    }


    public static WinningResult from(LottoTicket ticket, WinningLotto winningLotto) {
        return new WinningResult(ticket, winningLotto);
    }

    private void saveWinningResult(LottoTicket lottoTicket, WinningLotto winningLotto) {
        result = lottoTicket.getLottos().stream()
                .map(winningLotto::getRanking)
                .collect(groupingBy(ranking -> ranking, () -> new EnumMap<>(Ranking.class), counting()));
    }

    public Long getWinningCount(Ranking ranking) {
        return result.getOrDefault(ranking, 0L);
    }

    private void saveRateOfReturnPercent(LottoTicket lottoTicket){
        int purchaseAmount = lottoTicket.getLottos().size() * 1000;
        rateOfReturnPercent = ((double) getPrizeMoney() / purchaseAmount) *100;
    }

    private long getPrizeMoney() {
        return result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().calculatePrizeSum(entry.getValue()))
                .sum();
    }

    public double getRateOfReturnPercent() {
        return rateOfReturnPercent;
    }
}
