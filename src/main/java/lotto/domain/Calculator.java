package lotto.domain;

import static lotto.domain.Ranking.None;
import static lotto.domain.Ranking.Second;
import static lotto.utils.constants.LottoConstants.LOTTO_TICKET_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Calculator {

    public static Ranking calculateRanking(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> winningMainNumbers = winningNumbers.getMainNumbers().getNumbers();
        int winningBonusNumber = winningNumbers.getBonusNumber();

        int correctMainNumbersCount = compareMainNumbers(lotto, winningMainNumbers);
        boolean isNeedCheckBonusNumber = false;
        if (correctMainNumbersCount == Second.getCorrectCount()) {
            isNeedCheckBonusNumber = lotto.isMatch(winningBonusNumber);
        }

        Ranking result = getRanking(correctMainNumbersCount, isNeedCheckBonusNumber);
        return result;
    }

    private static Ranking getRanking(int correctMainNumbersCount, boolean isNeedCheckBonusNumber) {
        Ranking result = Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.getCorrectCount() == correctMainNumbersCount)
                .filter(ranking -> ranking.getNeedToCorrectBonusNumber()== isNeedCheckBonusNumber)
                .findAny()
                .orElse(None);
        return result;
    }

    private static int compareMainNumbers(Lotto lotto, List<Integer> winningMainNumbers) {
        return (int) winningMainNumbers.stream()
                .filter(lotto::isMatch)
                .count();
    }

    public static float calculateReturnOfRate(Map<Ranking, Integer> result, int ticketQuantity) {
        int totalRevenue = 0;
        for (Map.Entry<Ranking, Integer> entry : result.entrySet()) {
            int eachRankRevenue = entry.getKey().getReward() * entry.getValue();
            totalRevenue += eachRankRevenue;
        }
        return (float) totalRevenue / (ticketQuantity * LOTTO_TICKET_PRICE) * 100;
    }

}
