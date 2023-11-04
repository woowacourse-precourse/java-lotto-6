package lotto.userInterface;

import lotto.domain.Lotto;
import lotto.domain.Rank;

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
        System.out.println(lotto.showNumbers());
    }

    public static void printRequestWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printTitleOfResult() {
        System.out.println("당첨 통계\n---");
    }

    public static void printLottoResult(Rank rank, int rankCount) {
        int matchedCount = rank.getMatchCount();
        String amount = rank.getAmountMessage();
        if (rank == Rank.NO_RANK) {
            return;
        }
        if (rank == Rank.FIVE_AND_BONUS_MATCH) {
            System.out.println(matchedCount + "개 일치, 보너스 볼 일치 "
                    + "(" + amount + ") - " + rankCount + "개");
        }
        System.out.println(matchedCount + "개 일치 " + "(" + amount + ") - " + rankCount + "개");
    }

    public static void printProfitRatio(double profitRatio) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRatio) + "%입니다.");
    }
}
