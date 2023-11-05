package lotto.userInterface;

import lotto.constants.Rank;
import lotto.domain.Lotto;

public class OutputViewer {
    private OutputViewer() {
    }

    public static void printRequestAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printCountOfPurchaseLottos(int countOfLottos) {
        System.out.println(countOfLottos + "개를 구매했습니다.");
    }

    public static void printPurchasedLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printRequestWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printPrefaceOfResult() {
        System.out.println("당첨 통계\n---");
    }

    public static void printLottoResult(Rank rank, int rankCount) {
        int matchedCount = rank.getMatchCount();
        String amount = rank.getAmountMessage();
        if (rank == Rank.NO_RANK) {
            return;
        }
        if (rank == Rank.FIVE_AND_BONUS_MATCH) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s) - %d개\n", matchedCount, amount, rankCount);
        }
        System.out.printf("%d개 일치 (%s) - %d개\n", matchedCount, amount, rankCount);
    }

    public static void printProfitRatio(double profitRatio) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRatio) + "%입니다.");
    }
}
