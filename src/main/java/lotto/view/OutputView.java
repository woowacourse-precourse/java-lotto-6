package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {
    private static final String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void printPurchaseAmountMessage() {
        System.out.println(QUESTION_PURCHASE_AMOUNT);
    }

    public void printWinningNumberstMessage() {
        System.out.println(QUESTION_WINNING_NUMBERS);
    }

    public void printBonusNumberMessage() {
        System.out.println(QUESTION_BONUS_NUMBER);
    }

    public void printPurchasedLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");

        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printWinningResults(List<Rank> ranks) {
        System.out.println("당첨 통계\n---");

        for (Rank rank : Rank.values()) {
            long count = ranks.stream().filter(r -> r == rank).count();
            if (rank != Rank.NONE)
                System.out.printf(rank.getDescription() + " - %d개\n", count);
        }
    }

    public void printTotalProfit(double totalProfitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalProfitRate);
    }

    public void printErrorCode(String errorCode) {
        System.out.println(errorCode);
    }
}