package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;

public class WinningStatistics {
    private final WinningLotto winningLotto;

    private final List<Lotto> lottoTicketsPurchased;

    private final Map<LottoPrize, Integer> prizeCounter;
    private final double rateOfReturn;

    public WinningStatistics(WinningLotto winningLotto, List<Lotto> lottoTicketsPurchased,
                             Map<LottoPrize, Integer> prizeCounter, double rateOfReturn) {
        this.winningLotto = winningLotto;
        this.lottoTicketsPurchased = lottoTicketsPurchased;
        this.prizeCounter = prizeCounter;
        this.rateOfReturn = rateOfReturn;
    }

    public static WinningStatistics createDefaultWinningStatistics() {
        WinningLotto winningLotto = null;
        List<Lotto> lottoTicketsPurchased = new ArrayList<>();
        Map<LottoPrize, Integer> prizeCounter = new HashMap<>() {{
            Arrays.stream(LottoPrize.values())
                    .forEach(lottoPrize -> put(lottoPrize, 0));
        }};
        double rateOfReturn = 0;
        return new WinningStatistics(winningLotto, lottoTicketsPurchased, prizeCounter, rateOfReturn);
    }

    public Map<LottoPrize, Integer> getPrizeCounter() {
        return prizeCounter;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}