package lotto.domain.result;

import lotto.domain.Ranking;
import lotto.domain.lotto.LottoTicket;

import java.util.EnumMap;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static lotto.domain.lotto.PurchaseAmount.LOTTO_PRICE;

public class WinningResult {
    public static final double PERCENT_FACTOR = 100.0;
    private static final long ZERO_FOR_INVALID_KEY = 0L;

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


    private void saveRateOfReturnPercent(LottoTicket lottoTicket){
        int purchaseAmount = lottoTicket.getLottos().size() * LOTTO_PRICE;
        rateOfReturnPercent = ((double) getPrizeMoney() / purchaseAmount) *PERCENT_FACTOR;
    }

    private long getPrizeMoney() {
        return result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().calculatePrizeSum(entry.getValue()))
                .sum();
    }

    public double getRateOfReturnPercent() {
        return rateOfReturnPercent;
    }

    public Map<Ranking, Long> getResult() {
        return result;
    }
}
