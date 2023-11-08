package lotto.model;

import java.sql.Array;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.MatchNumber;
import lotto.ProfitCalculator;
import lotto.util.Constants;

public class LottoMatcher {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    private Map<MatchNumber, Integer> statistics = new EnumMap<>(MatchNumber.class);
    private double profitRate;

    public LottoMatcher(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.statistics = calculateStatistics();
        this.profitRate = calculateProfitRate();
    }


    public Map<MatchNumber, Integer> calculateStatistics() {
        for (Lotto lotto : lottos) {
            MatchNumber matchNumber = Lotteries.compareLottoNumber(lotto.getLottoNumber(), winningNumber, bonusNumber);
            statistics.put(matchNumber, statistics.getOrDefault(matchNumber, 0) + 1);

        }
        return statistics;
    }

    private double calculateProfitRate() {
        ProfitCalculator profitCalculator = new ProfitCalculator(lottos.size() * Constants.TICKET_MINIMUN_PRICE, statistics);
        return profitCalculator.calculateProfitRate();
    }

    public Map<MatchNumber, Integer> getStatistics() {
        return statistics;
    }

    public double getProfitRate() {
        return profitRate;
    }

}
