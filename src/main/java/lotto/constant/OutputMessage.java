package lotto.constant;

import java.util.List;

public enum OutputMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTO_QUANTITY("%d개를 구매했습니다."),
    LOTTO_NUMBERS("%s"),
    RESULTS_HEADER("당첨 통계"),
    RESULTS_SEPARATOR("---"),
    RESULT_LINE("%d개 일치 (%s원) - %d개"),
    RESULT_SECOND("5개 일치, 보너스 볼 일치 (%s원) - %d개"),
    PROFIT_RATE("총 수익률은 %s%%입니다."),
    NEW_LINE("\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageWithNewLine() {
        return NEW_LINE.getMessage() + this.message;
    }

    public String getMessageWithNewLine(int quantity) {
        return NEW_LINE.getMessage() + String.format(this.message, quantity);
    }

    public String format(String profitFormat) {
        return String.format(this.message, profitFormat);
    }

    public String format(List<Integer> lottoNumbers) {
        return String.format(this.message, lottoNumbers);
    }

    public String format(int matchCount, String prizeMoney, int count) {
        return String.format(this.message, matchCount, prizeMoney, count);
    }

    public String format(String text, int number) {
        return String.format(this.message, text, number);
    }
}
