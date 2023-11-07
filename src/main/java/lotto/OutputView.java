package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<LottoNumber> lottoNumbers = lotto.getNumbers();
            List<Integer> numbers = new ArrayList<>();
            for (LottoNumber lottoNumber : lottoNumbers) {
                numbers.add(lottoNumber.getNumber());
            }
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public static void printLottoResult(PurchasePrice purchasePrice, int earnMoney, Map<Rank, Integer> scoreTable) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println(
                "3개 일치 (" + df.format(Rank.RANK_5.getPrice()) + "원)" + " - " + scoreTable.getOrDefault(Rank.RANK_5, 0)
                        + "개");
        System.out.println(
                "4개 일치 (" + df.format(Rank.RANK_4.getPrice()) + "원)" + " - " + scoreTable.getOrDefault(Rank.RANK_4, 0)
                        + "개");
        System.out.println(
                "5개 일치 (" + df.format(Rank.RANK_3.getPrice()) + "원)" + " - " + scoreTable.getOrDefault(Rank.RANK_3, 0)
                        + "개");
        System.out.println(
                "5개 일치, 보너스 볼 일치 (" + df.format(Rank.RANK_2.getPrice()) + "원)" + " - " + scoreTable.getOrDefault(
                        Rank.RANK_2, 0) + "개");
        System.out.println(
                "6개 일치 (" + df.format(Rank.RANK_1.getPrice()) + "원)" + " - " + scoreTable.getOrDefault(Rank.RANK_1, 0)
                        + "개");
        printEarnMoney(purchasePrice, earnMoney);
    }

    private static void printEarnMoney(PurchasePrice purchasePrice, int earnMoney) {
        double profit = purchasePrice.calculateProfit(earnMoney);
        String round = String.format("%.1f", profit);
        System.out.println("총 수익률은 " + round + "%입니다.");
    }
}
