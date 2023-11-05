package lotto.domain;

import java.util.*;

public class PrizeResult {
    private static Map<Prize, Integer> prizeResult;

    private PrizeResult(Map<Prize, Integer> prizeResult) {
        this.prizeResult = prizeResult;
    }

    public static PrizeResult from(Lottos lottos, WinNumber winNumber) {
        return new PrizeResult(createPrizeResult(lottos, winNumber));
    }

    private static Map<Prize, Integer> createPrizeResult(Lottos lottos, WinNumber winNumber) {
        prizeResult = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            Prize prize = Prize.valueOf(getMatchCount(lotto, winNumber), hasBonus(lotto, winNumber));
            prizeResult.put(prize, prizeResult.getOrDefault(prize, 0) + 1);
        }
        return prizeResult;
    }

    public static Map<Prize, Integer> getPrizeResult() {
        return prizeResult;
    }

    public double calculateReturnRate(Map<Prize, Integer> prizeResult, Money money) {
        int totalPrizeAmount = prizeResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .sum();
        int totalInvestment = money.getMoney();
        return ((double) totalPrizeAmount / totalInvestment) * 100;
    }

    private static int getMatchCount(Lotto lotto, WinNumber winNumber) {
        Set<Integer> matchNumbers = new HashSet<>(lotto.getNumber());
        matchNumbers.retainAll(winNumber.getPickNumbers());
        return matchNumbers.size();
    }

    private static boolean hasBonus(Lotto lotto, WinNumber winNumber) {
        return lotto.getNumber().contains(winNumber.getBonusNumber());
    }

}