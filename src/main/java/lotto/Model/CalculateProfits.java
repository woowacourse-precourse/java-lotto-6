package lotto.Model;

import java.util.List;

public class CalculateProfits {
    //TODO : 수익률 계산
    // 수익/자본 *100 -> 소수점 .1.f까지만 표시
    public static double calculate(List<Integer> countWinnings, double investment){
        //TODO : enum기반
        //List<Integer> countWinnings = LottoMatch.countMatchingNumbers(totalNumbers, winningNumbers, bonus);
        double profit = 0;
        for (LottoPrize prize : LottoPrize.values()) {
            int prizeCount = countWinnings.get(prize.ordinal());
            profit += prizeCount * prize.getPrize();
        }
        double profitPercentage = (profit / investment) * 100;
        Result.printResults(countWinnings);
        System.out.println("총 수익률은 " + roundToTwoDecimalPlaces(profitPercentage) + "% 입니다.");
        return roundToTwoDecimalPlaces(profitPercentage);
    }
    private static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}
