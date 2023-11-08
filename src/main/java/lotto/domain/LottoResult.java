package lotto.domain;

import java.util.EnumMap;

public class LottoResult {

    private final Lottos lottos;
    private final WinningLotto winningLotto;

    private EnumMap<Ranking, Integer> result;

    public LottoResult(Lottos lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;

        result = new EnumMap<>(Ranking.class);
    }

    public void makeResult() {
        for (Ranking ranking : Ranking.values()) {
            result.put(ranking, 0);
        }

        lottos.getLottos().stream()
                .map(lotto -> Ranking.getRank(winningLotto.matchCount(lotto), winningLotto.isMatchBonusNumber(lotto)))
                .forEach(this::add);
    }

    public int get(Ranking ranking) {
        return result.get(ranking);
    }

    public double getProfitRate() {
        return (double) 100 * getProfit() / (lottos.size() * Lotto.PRICE);
    }

    private void add(Ranking ranking) {
        result.put(ranking, result.get(ranking) + 1);
    }

    private int getProfit() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

}
