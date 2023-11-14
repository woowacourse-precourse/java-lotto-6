package lotto.presentation.view;

import lotto.util.Rank;

public class View {
    private static final String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String PURCHASE_SIZE_MESSAGE = "%d개를 구매했습니다.";
    private static final String PROMPT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String DIVIDER = "---";

    public void promptForPurchaseAmount() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);
    }

    public void promptForError(IllegalArgumentException e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public void printPurchaseSize(int purchaseSize) {
        System.out.println();
        System.out.println(String.format(PURCHASE_SIZE_MESSAGE, purchaseSize));
    }

    public void printPurchaseLottoTicket(String lotto) {
        System.out.println(lotto);
    }

    public void promptForWinningNumber() {
        System.out.println();
        System.out.println(PROMPT_WINNING_NUMBER);
    }

    public void promptForBonusNumber() {
        System.out.println();
        System.out.println(PROMPT_BONUS_NUMBER);
    }

    public void promptForWinningStatistics() {
        System.out.println();
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(DIVIDER);
    }

    public void printWinningStatistics(Rank rank, int rankCount) {
        System.out.println(rank.toString() + " - " + rankCount + "개");
    }

    public void printReturnRate(double returnRate) {
        String formattedReturnRate = String.format("%.1f%%", returnRate);
        System.out.println("총 수익률은 " + formattedReturnRate + "입니다.");
    }
}