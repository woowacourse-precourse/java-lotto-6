package lotto.userInterface;

import java.util.List;
import lotto.constants.Rank;

public class OutputViewer {
    private OutputViewer() {
    }

    public static void printRequestAmountMessage() {
        System.out.println("\n구입금액을 입력해 주세요.");
    }

    public static void printNumberOf(int countOfLottery) {
        System.out.println("\n" + countOfLottery + "개를 구매했습니다.");
    }

    public static void printPurchased(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printRequestFirstRankNumberMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printPrefaceOfResult() {
        System.out.println("\n당첨 통계\n---");
    }

    public static void printLottoResultBy(Rank rank, int rankCount) {
        int matchedCount = rank.getMatchCount();
        String amount = rank.getAmountMessage();
        if (rank == Rank.NO_RANK) {
            return;
        }
        if (rank == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개\n", matchedCount, amount, rankCount);
            return;
        }
        System.out.printf("%d개 일치 (%s) - %d개\n", matchedCount, amount, rankCount);
    }

    public static void printLastMessageWith(double profitRatio) {
        if (profitRatio == Double.POSITIVE_INFINITY) {
            System.out.println("총 수익률은 무한대입니다.");
            return;
        }
        System.out.println("총 수익률은 " + String.format("%.1f", profitRatio) + "%입니다.");
    }
}
