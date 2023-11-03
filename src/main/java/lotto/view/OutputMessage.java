package lotto.view;

import lotto.domain.Ranking;

public enum OutputMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요.\n"),
    REQUEST_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요.\n"),
    REQUEST_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n"),

    RESPONSE_PURCHASE_COUNT("\n%d개를 구매했습니다.\n"),
    RESPONSE_USER_NUMBERS_SET("%s\n"),
    RESPONSE_WINNING_STATISTICS_HEADER("당첨 통계\n---\n"),
    RESPONSE_WINNING_STATISTICS_BODY(
            Ranking.FIFTH.getMatchedNumberCount() + "개 일치 (" + String.format("%,d", Ranking.FIFTH.getWinningAmount()) + "원) - %d개\n" +
            Ranking.FOURTH.getMatchedNumberCount() + "개 일치 (" + String.format("%,d", Ranking.FOURTH.getWinningAmount()) + "원) - %d개\n" +
            Ranking.THIRD.getMatchedNumberCount() + "개 일치 (" + String.format("%,d", Ranking.THIRD.getWinningAmount()) + "원) - %d개\n" +
            Ranking.SECOND.getMatchedNumberCount() + "개 일치, 보너스 볼 일치 (" + String.format("%,d", Ranking.SECOND.getWinningAmount()) + "원) - %d개\n" +
            Ranking.FIRST.getMatchedNumberCount() + "개 일치 (" + String.format("%,d", Ranking.FIRST.getWinningAmount()) + "원) - %d개\n"
    ),
    RESPONSE_TOTAL_RETURN("총 수익률은 %s%%입니다.\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
