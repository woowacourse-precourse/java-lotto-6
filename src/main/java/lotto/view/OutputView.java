package lotto.view;

import java.util.List;

import static lotto.domain.WinningStatistics.*;
import static lotto.view.constatnt.OutputMessage.*;

public class OutputView {


    public void inputPurchaseMoneyMessage() {
        System.out.println(INPUT_PURCHASE_MONEY.getMessage());
    }

    public void inputNumbersMessage() {
        System.out.println(INPUT_LOTTO.getMessage());
    }

    public void inputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
    }

    public void noticePurchaseCountMessage(int purchaseCount) {
        System.out.println("\n" + purchaseCount + NOTICE_PURCHASE_COUNT.getMessage());
    }

    public void noticeRandomLottoMessage(int amount, List<List<Integer>> lottos) {
        for(int i = 0; i < amount; i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void noticeWinningStatisticsMessage(List<Integer> counts) {
        System.out.println(NOTICE_WINNING_STATISTICS.getMessage());
        System.out.println(FIFTH.getMessage() + counts.get(0) + COUNT.getMessage()
                + FOURTH.getMessage() + counts.get(1) + COUNT.getMessage()
                + THIRD.getMessage() + counts.get(2) + COUNT.getMessage()
                + SECOND.getMessage() + counts.get(3) + COUNT.getMessage()
                + FIRST.getMessage() + counts.get(4) + COUNT.getMessage());
    }

    public void noticeWinningRateMessage(double statistics) {
        System.out.println(NOTICE_STATISTICS1.getMessage() + statistics + NOTICE_STATISTICS2.getMessage());
    }

    public void errorMessage() {
        System.out.println("\n[ERROR] 숫자를 다시 입력하세요.");
    }
}
