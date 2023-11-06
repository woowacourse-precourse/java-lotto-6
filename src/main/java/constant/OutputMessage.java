package constant;

import java.text.DecimalFormat;

public enum OutputMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.\n"),
    BUY_LOTTOES("\n%d개를 구매했습니다.\n"),
    INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n"),
    WINNING_STATISTICS("\n당첨 통계\n---\n"),
    MATCH_COUNT("%d개 일치 (%s원) - %d개\n"),
    MATCH_COUNT_RANK_2("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    TOTAL_RATE_OF_RETURN("총 수익률은 %s%%입니다.\n"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public String get(int count) {
        if (message.equals(BUY_LOTTOES.message)) {
            return String.format(message, count);
        }
        return message;
    }

    public String get(double rateOfReturn) {
        if (message.equals(TOTAL_RATE_OF_RETURN.message)) {
            return String.format(message, calculateRateOfReturn(rateOfReturn));
        }
        return message;
    }

    private String calculateRateOfReturn(double rateOfReturn) {
        DecimalFormat formatter = new DecimalFormat("##.#");
        return formatter.format(rateOfReturn);
    }

    public String get(int rank, int rankCount) {
        if (message.equals(MATCH_COUNT.message) || message.equals(MATCH_COUNT_RANK_2.message)) {
            return String.format(message, getMatchingCount(rank), getWinningPrize(rank), rankCount);
        }
        return message;
    }

    private int getMatchingCount(int rank) {
        final int winningNumberCount = ConstantNumber.WINNING_NUMBER_COUNT.get();
        if (rank == 1) {
            return winningNumberCount;
        }
        if (rank == 2) {
            return winningNumberCount - 1;
        }
        return winningNumberCount - rank + 2;
    }

    private String getWinningPrize(int rank) {
        int prize = WinningPrize.values()[rank - 1].get();
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(prize);
    }
}
