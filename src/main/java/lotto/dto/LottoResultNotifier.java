package lotto.dto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoDraw;
import lotto.model.Lottos;
import lotto.util.LottoResult;

public class LottoResultNotifier {

    private static final int UNIT_MONEY = 1000;

    private final Lottos lottos;

    private final LottoDraw lottoDraw;

    private final LottoResult[] lottoResults = LottoResult.values();

    private Map<LottoResult, Integer> totalWinningResult;

    public LottoResultNotifier(Lottos lottos, LottoDraw lottoDraw) {
        init();
        calculateResult(lottos, lottoDraw);
        this.lottos = lottos;
        this.lottoDraw = lottoDraw;
    }

    public Map<LottoResult, Integer> getResultMap() {
        return Collections.unmodifiableMap(totalWinningResult);
    }

    public String getRateOfReturn() {
        int purchaseAmount = lottos.getSize() * UNIT_MONEY;
        long winningAmount = getTotalWinningAmount();
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 최소 1개이상 구입해야 합니다.");
        }
        double rateOfReturn = ((double) winningAmount / purchaseAmount) * 100.0;
        return String.format("%.1f", rateOfReturn);
    }

    public long getTotalWinningAmount() {
        return totalWinningResult.entrySet().stream()
                .mapToLong(e -> e.getKey().getAmount() * e.getValue())
                .sum();
    }

    public List<Map.Entry<LottoResult, Integer>> sortByAscendingWinnings() {
        return totalWinningResult.entrySet().stream()
                .sorted((o1, o2) -> Math.toIntExact(o1.getKey().getAmount() - o2.getKey().getAmount()))
                .toList();
    }

    private void init() {
        this.totalWinningResult = new EnumMap<>(LottoResult.class);
        for (LottoResult lottoResult : lottoResults) {
            totalWinningResult.put(lottoResult, totalWinningResult.getOrDefault(lottoResult, 0));
        }
    }

    private void calculateResult(Lottos lottos, LottoDraw lottoDraw) {
        List<Lotto> lottoBundle = lottos.lottoBundle();
        for (Lotto lotto : lottoBundle) {
            LottoResult result = LottoResult.calculateResult(lotto, lottoDraw);
            totalWinningResult.put(result, totalWinningResult.getOrDefault(result, 0) + 1);
        }
    }

}
