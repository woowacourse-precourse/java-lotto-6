package lotto;

import static lotto.Ranking.None;
import static lotto.Ranking.Second;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Calculator {

    public static Ranking caculateRanking(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> winningMainNumbers = winningNumbers.getMainNumbers().getNumbers();
        int winningBonusNumber = winningNumbers.getBonusNumber();
        int correctMainNumbersCount = caculateMainNumber(lotto, winningMainNumbers);
        boolean isCorrectBonusNumber = false;
        if (correctMainNumbersCount == Second.getCorrectCount()) {
            isCorrectBonusNumber = lotto.isMatch(winningBonusNumber);
        }
        boolean finalIsCorrectBonusNumber = isCorrectBonusNumber;
        Ranking result = Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.getCorrectCount() == correctMainNumbersCount)
                .filter(ranking -> ranking.getNeedToCorrectBonusNumber() == finalIsCorrectBonusNumber)
                .findAny()
                .orElse(None);

        return result;

    }

    private static int caculateMainNumber(Lotto lotto, List<Integer> winningMainNumbers) {
        return (int) winningMainNumbers.stream()
                .filter(lotto::isMatch)
                .count();
    }

    public static float caculateReturnOfRate(Map<Ranking, Integer> result, int ticketQuantity ) {
        int totalRevenue = 0;
        for (Map.Entry<Ranking, Integer> entry : result.entrySet()) {
            int eachRankRevenue = entry.getKey().getReward()*entry.getValue();
            totalRevenue +=eachRankRevenue;
        }
        return (float) totalRevenue/(ticketQuantity*1000)*100;
    }
}
