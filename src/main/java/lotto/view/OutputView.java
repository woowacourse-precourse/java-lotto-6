package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {
    private static final String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "당첨 통계";
    private static final String BOUNDARY_LINE = "---";
    private static final String WINNING_RESULT_TEMPLATE = " - %d개\n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

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
        System.out.println(lottoTickets.size() + PURCHASED_LOTTO_COUNT_MESSAGE);

        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public void printWinningResults(List<Rank> ranks) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(BOUNDARY_LINE);

        for (Rank rank : Rank.values()) {
            long count = ranks.stream().filter(r -> r == rank).count();
            if (rank != Rank.NONE)
                System.out.printf(rank.getDescription() + WINNING_RESULT_TEMPLATE, count);
        }
    }

    public void printTotalProfit(double totalProfitRate) {
        System.out.printf(EARNING_RATE_MESSAGE, totalProfitRate);
    }

    public void printErrorCode(String errorCode) {
        System.out.println(errorCode);
    }

    public void println() {
        System.out.println();
    }
}