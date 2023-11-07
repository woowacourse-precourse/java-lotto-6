package lotto.View;

import lotto.model.Lotto;
import lotto.model.LottoResult;

import java.util.List;


public class Lottogameview {
  public void printPurchasedLottosCount(int numberOfLotto) {
        System.out.println(numberOfLotto + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumbers(lotto.getNumbers());
        }
    }

    private void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    private String formatResultLine(LottoResult result, int[] winCounts) {
        if (result == LottoResult.THIRD && winCounts[LottoResult.FOURTH.ordinal()] > 0) {
            int bonusCount = winCounts[LottoResult.FOURTH.ordinal()];
            return formatBonusResultLine(bonusCount, LottoResult.FOURTH.getPrize());
        }

        String formattedPrize = formatPrize(result.getPrize());

        if (result == LottoResult.FOURTH) {
            return result.getMatchingNumbers() + "개 일치, 보너스 볼 일치 (" + formattedPrize + "원) - " + winCounts[result.ordinal()] + "개";
        }

        return result.getMatchingNumbers() + "개 일치 (" + formattedPrize + "원) - " + winCounts[result.ordinal()] + "개";
    }

    private String formatBonusResultLine(int bonusCount, int prize) {
        return "5개 일치, 보너스 볼 일치 (" + formatPrize(prize) + "원) - " + bonusCount + "개";
    }

    private double calculateTotalProfitRate(int purchaseAmount, int[] winCounts) {
        int totalPrize = calculateTotalPrize(winCounts);
        return calculateProfitRate(purchaseAmount, totalPrize);
    }

    private int calculateTotalPrize(int[] winCounts) {
        int totalPrize = 0;
        for (LottoResult result : LottoResult.values()) {
            totalPrize += result.getPrize() * winCounts[result.ordinal()];
        }
        return totalPrize;
    }

    private double calculateProfitRate(int purchaseAmount, int totalPrize) {
        return (double) totalPrize / purchaseAmount * 100;
    }

    private String formatPrize(int prize) {
        return String.format("%,d", prize);
    }

    public void printWinningResult(int[] winCounts, int purchaseAmount) {
        for (LottoResult result : LottoResult.values()) {
            String resultLine = formatResultLine(result, winCounts);
            System.out.println(resultLine);
        }

        double totalProfitRate = calculateTotalProfitRate(purchaseAmount, winCounts);
        System.out.println("총 수익률은 " + String.format("%.1f%%", totalProfitRate) + "입니다.");
    }
}
