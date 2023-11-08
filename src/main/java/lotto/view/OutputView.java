package lotto.view;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.Lotto;
import lotto.util.*;

public class OutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.forEach(lotto -> {
            List<Integer> numberList = new ArrayList<>(lotto.getNumbers());
            numberList.sort(Comparator.naturalOrder()); // 번호를 오름차순으로 정렬
            System.out.println("[" + numberList + "]");
        });
    }

    public static void printWinningStatistics(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        int[] prizeCounts = new int[6];

        for (Lotto lotto : lottos) {
            int matchedNumbers = LottoUtils.countMatchedNumbers(lotto, winningLotto);
            boolean hasBonusNumber = lotto.containsNumber(bonusNumber);
            updatePrizeCounts(prizeCounts, matchedNumbers, hasBonusNumber);
        }

        System.out.println("당첨 통계");
        System.out.println("---");

        printPrize(3, prizeCounts, 4, "5등", 5_000);
        printPrize(4, prizeCounts, 3, "4등", 50_000);
        printPrize(5, prizeCounts, 2, "3등", 1_500_000);
        printPrize(5, prizeCounts, 1, "2등", 30_000_000);
        printPrize(6, prizeCounts, 0, "1등", 2_000_000_000);
        System.out.println("꽝: " + prizeCounts[5] + "개");
    }

    private static void updatePrizeCounts(int[] prizeCounts, int matchedNumbers, boolean hasBonusNumber) {
        if (matchedNumbers == 6)
            prizeCounts[0]++;
        if (matchedNumbers == 5 && hasBonusNumber)
            prizeCounts[1]++;
        if (matchedNumbers == 5 && !hasBonusNumber)
            prizeCounts[2]++;
        if (matchedNumbers == 4)
            prizeCounts[3]++;
        if (matchedNumbers == 3)
            prizeCounts[4]++;
        if (matchedNumbers == 2 || matchedNumbers == 1 || matchedNumbers == 0)
            prizeCounts[5]++;
    }

    private static void printPrize(int sameCount, int[] prizeCounts, int matchedNumbers, String prizeName, int prizeAmount) {
        int count = prizeCounts[matchedNumbers];
        int prizePerThousand = prizeAmount / 1_000;
        if (matchedNumbers == 1) {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
            return;
        }
        System.out.println(sameCount + "개 일치 (" + formatNumberWithCommas(prizeAmount) + "원) - " + count + "개");

    }

    private static String formatNumberWithCommas(int number) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        return numberFormat.format(number);
    }


    // 최종 결과 출력
    public static void printResult(int totalPrize, int purchaseAmount, List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        LottoUtils LottoUtils = null;
        double profitRate = LottoUtils.calculateProfitRate(purchaseAmount, totalPrize);
        printWinningStatistics(lottos, winningLotto, bonusNumber);
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }

}
