package lotto.domain;

import java.util.*;

import static lotto.constant.Constants.*;

public class WinningStats {
    private final int purchasePrice;
    private final Lottos lottos;
    private final WinningLotto winningLotto;

    private WinningStats(int purchasePrice, Lottos lottos, WinningLotto winningLotto) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public static WinningStats createWinningStats(int winningAmount, Lottos lottos, WinningLotto winningLotto) {
        return new WinningStats(winningAmount, lottos, winningLotto);
    }

    public String getResultMessage() {
        EnumMap<Rank, Integer> lottoStats = getLottoStats();
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        lottoStats.forEach((key, value) -> joiner.add(key.getMessage(value)));

        return joiner.toString();
    }

    public double getRateOfReturn() {
        EnumMap<Rank, Integer> lottoStats = getLottoStats();
        int totalWinningAmount = 0;

        for (Map.Entry<Rank, Integer> entry : lottoStats.entrySet()) {
            Rank key = entry.getKey();
            Integer value = entry.getValue();
            totalWinningAmount += key.getWinningAmount() * value;
        }

        return (double) totalWinningAmount / (double) purchasePrice * PERCENTAGE;
    }

    private EnumMap<Rank, Integer> getLottoStats() {
        EnumMap<Rank, Integer> result = Rank.createEnumMap();

        lottos.getLottos().stream().map(lotto -> Rank.matchRank(lotto, winningLotto))
                .filter(Objects::nonNull)
                .forEach(Rank -> result.put(Rank, result.get(Rank) + 1));

        return result;
    }
}
