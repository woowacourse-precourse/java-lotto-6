package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    public static final int DEFAULT_COUNT = 0;
    public static final int INCREMENT_COUNT = 1;
    public static final double PERCENTAGE_MULTIPLIER = 100.0;
    private final Map<Rank, Integer> winningResult;

    public Statistics(Map<Rank, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public double calculateRateOfReturn(Money purchaseMoney){
        double winningAmount = Arrays.stream(Rank.values())
            .mapToInt(rank -> winningResult.get(rank) * rank.getWinningMoney())
            .sum();
        double rateOfReturn = (winningAmount / purchaseMoney.amount()) * PERCENTAGE_MULTIPLIER;
        return rateOfReturn;
    }

    public Map<Rank, Integer> getWinningResult(){
        return winningResult;
    }

    public static Map<Rank, Integer> calculateWinningResult(
            List<Lotto> lottoTickets, WinningNumber winningNumbers) {
        Map<Rank, Integer> winningResult = initWinningResult();
        lottoTickets.forEach(lotto -> {
                int countOfMatch = lotto.countMatchingNumber(winningNumbers.winningLotto());
                boolean hasBonus = lotto.contains(winningNumbers.bonusNumber());
                Rank rank = Rank.getRank(countOfMatch, hasBonus);
                winningResult.put(rank, winningResult.get(rank) + INCREMENT_COUNT);
        });
        return winningResult;
    }

    public static Map<Rank, Integer> initWinningResult() {
        Map<Rank, Integer> winningResult = new EnumMap<>(Rank.class);
        Arrays.asList(Rank.values())
                .forEach(value -> winningResult.put(value, DEFAULT_COUNT));
        return winningResult;
    }
}
